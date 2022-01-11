package fr.mines.ales.web.services.tp;

import fr.mines.ales.web.services.tp.entities.Room;
import fr.mines.ales.web.services.tp.entities.RoomTypeEnum;
import fr.mines.ales.web.services.tp.repositories.RoomRepositoryLocal;
import fr.mines.ales.web.services.tp.services.RoomService;

import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Room r1 = new Room();
        r1.setId(1);
        r1.setRoomType(RoomTypeEnum.BASIC);
        r1.setPrice(123);

        Room r2 = new Room();
        r2.setId(2);
        r2.setRoomType(RoomTypeEnum.HIGH);
        r2.setPrice(399);

        List<Room> rooms = new ArrayList<>();
        rooms.add(r1);
        rooms.add(r2);

        ApplicationProvider.setRoomRepository(new RoomRepositoryLocal(rooms, new ArrayList<>()));
        Endpoint endpoint = Endpoint.publish("http://localhost:8081/ws/roomService", new RoomService());
    }
}
