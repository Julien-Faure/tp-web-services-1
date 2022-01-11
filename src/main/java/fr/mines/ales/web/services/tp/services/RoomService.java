package fr.mines.ales.web.services.tp.services;

import fr.mines.ales.web.services.tp.ApplicationProvider;
import fr.mines.ales.web.services.tp.entities.Room;
import fr.mines.ales.web.services.tp.repositories.RoomRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<Room> listRoom(Date startDate, Date endDate) throws RoomServiceException {
        RoomRepository roomRepository = ApplicationProvider.getRoomRepository();
        return roomRepository.getAvailableRooms(startDate, endDate);
    }

    @Override
    public List<Room> listAllRoom() throws RoomServiceException {
        return ApplicationProvider.getRoomRepository().getAllRooms();
    }
}
