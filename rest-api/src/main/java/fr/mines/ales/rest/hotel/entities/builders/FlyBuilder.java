package fr.mines.ales.rest.hotel.entities.builders;

import fr.mines.ales.rest.hotel.entities.Fly;

import java.util.Date;

public final class FlyBuilder {
    private int id;
    private String departureLocation;
    private String arrivalLocation;
    private Date departureDate;
    private Date arrivalDate;

    private FlyBuilder() {
    }

    public static FlyBuilder create() {
        return new FlyBuilder();
    }

    public FlyBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public FlyBuilder setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
        return this;
    }

    public FlyBuilder setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
        return this;
    }

    public FlyBuilder setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public FlyBuilder setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
        return this;
    }

    public Fly build() {
        return new Fly(id, departureLocation, arrivalLocation, departureDate, arrivalDate);
    }
}
