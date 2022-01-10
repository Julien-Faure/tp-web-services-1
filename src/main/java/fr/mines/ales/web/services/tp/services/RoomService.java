package fr.mines.ales.web.services.tp.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RoomService implements IRoomService {

    @WebMethod
    public void bookRoom(int roomId) throws RoomServiceException {

    }
}
