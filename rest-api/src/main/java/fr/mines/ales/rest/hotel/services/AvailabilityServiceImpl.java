package fr.mines.ales.rest.hotel.services;

import fr.mines.ales.rest.hotel.ApplicationProvider;
import fr.mines.ales.rest.hotel.entities.AvailabilityResult;
import fr.mines.ales.rest.hotel.repositories.FlyRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Date;

@Path("/availability")
public class AvailabilityServiceImpl implements AvailabilityService {

    @Path("/all/{startDate}/{endDate}")
    @Produces("application/json")
    @GET
    @Override
    public AvailabilityResult getAvailabilities(@PathParam("startDate") long startDate,
                                                @PathParam("endDate") long endDate) {
        Date d1 = new Date(startDate);
        Date d2 = new Date(endDate);
        FlyRepository flyRepository = ApplicationProvider.getFlyRepository();
        return new AvailabilityResult(flyRepository.getAllFly(d1,d2));
    }

    @Path("/all")
    @Produces("application/json")
    @GET
    @Override
    public AvailabilityResult getAvailabilities() {
        FlyRepository flyRepository = ApplicationProvider.getFlyRepository();
        return   new AvailabilityResult(flyRepository.getAllFly());
    }
}
