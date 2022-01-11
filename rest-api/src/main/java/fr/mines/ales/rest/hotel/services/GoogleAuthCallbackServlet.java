package fr.mines.ales.rest.hotel.services;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebServlet(urlPatterns = "/google/callback")
public class GoogleAuthCallbackServlet extends AbstractAuthorizationCodeCallbackServlet {
    private static final String CLIENT_ID = "224258289902-cfpdaenlg0c7p4a3mtqrklq4rjk9g3mq.apps.googleusercontent.com";
    public static final String CLIENT_SECRET = "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";

    @Override
    protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential) throws ServletException, IOException {
        System.out.println("Success");
        String accessToken = credential.getAccessToken();
        System.out.println(accessToken);
        //Save the token pls
        Oauth2 oauth2 = new Oauth2.Builder(new NetHttpTransport(), new GsonFactory(), credential).setApplicationName(
                "Oauth2").build();
        Userinfoplus userinfo = oauth2.userinfo().get().execute();

        resp.setStatus(200);
        resp.getOutputStream().println("Hello " + userinfo.getName());
    }

    @Override
    protected AuthorizationCodeFlow initializeFlow() throws IOException {
        return new GoogleAuthorizationCodeFlow.Builder(
                new NetHttpTransport(), GsonFactory.getDefaultInstance(),
                CLIENT_ID, CLIENT_SECRET,
                Collections.singleton("https://www.googleapis.com/auth/userinfo.profile")).build();
    }

    @Override
    protected String getRedirectUri(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        GenericUrl url = new GenericUrl(httpServletRequest.getRequestURL().toString());
        url.setRawPath("/rest-api/google/callback");
        return url.build();
    }

    @Override
    protected String getUserId(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        return "salut";
    }
}
