package fr.mines.ales.web.services.tp.services;

import fr.mines.ales.web.services.tp.entities.Room;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface IRoomService {
    @WebMethod
    void bookRoom(int roomId, Date startDate, Date endDate) throws RoomServiceException;
    @WebMethod
    List<Room> listRoom(Date startDate, Date endDate) throws RoomServiceException;
    @WebMethod
    List<Room> listAllRoom() throws RoomServiceException;
}
