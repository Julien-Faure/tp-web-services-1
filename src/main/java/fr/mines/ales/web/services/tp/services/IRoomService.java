package fr.mines.ales.web.services.tp.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Date;

@WebService
public interface IRoomService {
    @WebMethod
    void bookRoom(int roomId, Date startDate, Date endDate) throws RoomServiceException;
}
