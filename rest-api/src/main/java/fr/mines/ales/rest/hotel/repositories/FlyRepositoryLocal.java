package fr.mines.ales.rest.hotel.repositories;

import fr.mines.ales.rest.hotel.entities.Fly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FlyRepositoryLocal implements FlyRepository {

    List<Fly> flyList;

    public FlyRepositoryLocal(List<Fly> flyList) {
        this.flyList = flyList;
    }

    @Override
    public List<Fly> getAllFly(Date departure, Date arrival) {
        List<Fly> flyListFiltered = new ArrayList<>();

        for (Fly fly : flyList)
           if(fly.getArrivalDate().after(departure) && fly.getArrivalDate().before(arrival))
               flyListFiltered.add(fly);

        return flyListFiltered;
    }

    @Override
    public List<Fly> getAllFly() {
        return Collections.unmodifiableList(flyList);
    }
}
