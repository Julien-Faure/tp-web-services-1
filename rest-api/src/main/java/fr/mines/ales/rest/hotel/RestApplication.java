package fr.mines.ales.rest.hotel;

import fr.mines.ales.rest.hotel.services.AvailabilityServiceImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        fr.mines.ales.rest.hotel.Application.start();
        Set<Class<?>> classes = new HashSet<>();
        classes.add(AvailabilityServiceImpl.class);
        classes.add(CORSFilter.class);
        return classes;
    }
}
