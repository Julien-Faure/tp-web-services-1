package fr.mines.ales.web.services.tp;

import fr.mines.ales.web.services.tp.services.RoomService;

import javax.xml.ws.Endpoint;


public class Main {
    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.publish("http://localhost:8080/ws/roomService", new RoomService());

    }
}
