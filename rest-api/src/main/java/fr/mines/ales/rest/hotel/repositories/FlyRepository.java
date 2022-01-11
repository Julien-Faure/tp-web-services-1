package fr.mines.ales.rest.hotel.repositories;

import fr.mines.ales.rest.hotel.entities.Fly;

import java.util.Date;
import java.util.List;

public interface FlyRepository {
    List<Fly> getAllFly(Date departure, Date arrival);
    List<Fly> getAllFly();
}
