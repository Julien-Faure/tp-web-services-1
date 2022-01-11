package fr.mines.ales.web.services.tp.repositories;

import fr.mines.ales.web.services.tp.entities.BookedRoom;
import fr.mines.ales.web.services.tp.entities.Room;
import fr.mines.ales.web.services.tp.list.RoomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class RoomRepositoryLocal implements RoomRepository {
    private final List<Room> rooms;
    private final List<BookedRoom> bookedRooms;

    public RoomRepositoryLocal(List<Room> rooms, List<BookedRoom> bookedRooms) {
        this.rooms = rooms;
        this.bookedRooms = bookedRooms;
    }

    @Override
    public List<Room> getAvailableRooms(Date startDate, Date endDate) {
        RoomList roomList = new RoomList(new ArrayList<>(rooms));
        List<BookedRoom> bookedRooms = getBookedRooms();
        for (BookedRoom room : bookedRooms) {
            if (!room.getStartDate().before(endDate) && room.getEndDate().after(startDate))
                roomList.remove(room.getRoom().getId());
        }

        return roomList.toList();
    }

    @Override
    public List<Room> getAllRooms() {
        return Collections.unmodifiableList(rooms);
    }

    @Override
    public List<BookedRoom> getBookedRooms() {
        return Collections.unmodifiableList(bookedRooms);
    }
}
