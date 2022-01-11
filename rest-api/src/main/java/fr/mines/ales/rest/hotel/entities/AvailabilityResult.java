package fr.mines.ales.rest.hotel.entities;

import fr.mines.ales.web.services.tp.services.Room;

import java.util.Collections;
import java.util.List;

public class AvailabilityResult {
    private final List<Fly> flightList;
    private final List<Room> roomList;

    public AvailabilityResult(List<Fly> flyList, List<Room> roomList) {
        this.flightList = flyList;
        this.roomList = roomList;
    }

    public List<Fly> getFlightList() {
        return Collections.unmodifiableList(flightList);
    }

    public List<Room> getRoomList() {
        return roomList;
    }
}
