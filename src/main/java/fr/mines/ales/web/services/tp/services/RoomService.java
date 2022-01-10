package fr.mines.ales.web.services.tp.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Date;

@WebService
public class RoomService implements IRoomService {

    private void bookRoom(int roomId) throws RoomServiceException {
        System.out.println("Demande de réservation reçue pour la chambre " + roomId);
    }

    @WebMethod
    public void bookRoom(int roomId, Date startDate, Date endDate) throws RoomServiceException {
        bookRoom(roomId);
        System.out.printf("Du %s au %s.\n", startDate, endDate);
    }
}
