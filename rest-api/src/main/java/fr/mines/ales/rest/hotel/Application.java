package fr.mines.ales.rest.hotel;

import fr.mines.ales.rest.hotel.entities.Fly;
import fr.mines.ales.rest.hotel.entities.builders.FlyBuilder;
import fr.mines.ales.rest.hotel.repositories.FlyRepositoryLocal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Application {
    public static void start() {
        FlyBuilder flyBuilder = FlyBuilder.create();
        List<Fly> flyList = new ArrayList<>();

        flyBuilder.setDepartureDate(new GregorianCalendar(2021, Calendar.FEBRUARY, 12, 10, 23).getTime());
        flyBuilder.setArrivalDate(new GregorianCalendar(2021, Calendar.FEBRUARY, 12, 12, 23).getTime());
        flyBuilder.setId(12);
        flyBuilder.setDepartureLocation("Nîmes");
        flyBuilder.setArrivalLocation("Paris");


        flyList.add(flyBuilder.build());

        flyBuilder.setDepartureDate(new GregorianCalendar(2021, Calendar.FEBRUARY, 14, 9, 0).getTime());
        flyBuilder.setArrivalDate(new GregorianCalendar(2021, Calendar.FEBRUARY, 14, 15, 23).getTime());
        flyBuilder.setId(34);
        flyBuilder.setDepartureLocation("Montpellier");
        flyBuilder.setArrivalLocation("Lille");

        flyList.add(flyBuilder.build());

        FlyRepositoryLocal flyRepositoryLocal = new FlyRepositoryLocal(flyList);
        ApplicationProvider.setFlyRepository(flyRepositoryLocal);
    }
}
