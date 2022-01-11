package fr.mines.ales.web.services.tp.list;

import fr.mines.ales.web.services.tp.entities.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomList {
    private final List<Room> rooms;

    public RoomList(List<Room> rooms) {
        this.rooms = rooms;
    }

    public RoomList() {
        this.rooms = new ArrayList<>();
    }

    public void remove(int roomId) {
        Room room = getRoom(roomId);
        if(room != null)
            this.rooms.remove(room);
    }

    public  List<Room> toList(){
        return rooms;
    }

    public Room getRoom(int roomId) {
        int i = 0;
        Room found = null;

        while (i < rooms.size() && found == null) {
            Room current = rooms.get(i);
            if (current.getId() == roomId)
                found = current;
            else i++;
        }

        return found;
    }

}
