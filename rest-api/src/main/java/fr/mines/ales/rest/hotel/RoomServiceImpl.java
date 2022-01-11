package fr.mines.ales.rest.hotel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/hotel/")
public class RoomServiceImpl implements RoomService {

    @Path("/book/{roomId}")
    @Produces("text/plain")
    @GET
    @Override
    public String bookRoom(@PathParam("roomId") int roomId) {
        System.out.println("Salut " + roomId);
        return "OK ma boi";
    }
}
