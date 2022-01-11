package fr.mines.ales.rest.hotel.entities;

import java.util.Date;

public class Fly {
    private final int id;
    private final String departureLocation;
    private final String arrivalLocation;
    private final Date departureDate;
    private final Date arrivalDate;

    public Fly(int id, String departureLocation, String arrivalLocation, Date departureDate, Date arrivalDate) {
        this.id = id;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public int getId() {
        return id;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }
}
