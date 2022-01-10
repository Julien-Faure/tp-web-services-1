package fr.mines.ales.web.services.tp.services;

import javax.jws.WebMethod;

public interface IRoomService {
    @WebMethod
    void bookRoom(int roomId) throws RoomServiceException;
}
