package fr.mines.ales.rest.hotel.services;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


@WebServlet(urlPatterns = "/google/auth")
public class GoogleAuthImpl extends AbstractAuthorizationCodeServlet {
    private static final String CLIENT_ID = "224258289902-cfpdaenlg0c7p4a3mtqrklq4rjk9g3mq.apps.googleusercontent.com";
    public static final String CLIENT_SECRET = "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";

    @Override
    protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
        GenericUrl url = new GenericUrl(req.getRequestURL().toString());
        url.setRawPath("/rest-api/google/callback");
        return url.build();
    }

    @Override
    protected AuthorizationCodeFlow initializeFlow() throws IOException {
        return new GoogleAuthorizationCodeFlow.Builder(
                new NetHttpTransport(), GsonFactory.getDefaultInstance(),
                CLIENT_ID, CLIENT_SECRET,
                Collections.singleton("https://www.googleapis.com/auth/userinfo.profile")).build();
    }

    @Override
    protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
        // return user ID
        return "user_id";
    }
}
