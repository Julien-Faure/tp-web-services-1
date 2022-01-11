package fr.mines.ales.web.services.tp.repositories;

import fr.mines.ales.web.services.tp.entities.BookedRoom;
import fr.mines.ales.web.services.tp.entities.Room;

import java.util.Date;
import java.util.List;

public interface RoomRepository {
    List<Room> getAvailableRooms(Date startDate, Date endDate);
    List<Room> getAllRooms();
    List<BookedRoom> getBookedRooms();
}
