package fr.mines.ales.rest.hotel.entities;

import java.util.Collections;
import java.util.List;

public class AvailabilityResult {
    private final List<Fly> flightList;

    public AvailabilityResult(List<Fly> flyList) {
        this.flightList = flyList;
    }

    public List<Fly> getFlightList() {
        return Collections.unmodifiableList(flightList);
    }
}
