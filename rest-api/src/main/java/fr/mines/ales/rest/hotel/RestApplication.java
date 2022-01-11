package fr.mines.ales.rest.hotel;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Collections.singletonList(RoomServiceImpl.class));
    }
}
