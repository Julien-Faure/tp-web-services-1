package fr.mines.ales.rest.hotel.services;


import fr.mines.ales.rest.hotel.entities.AvailabilityResult;

import java.util.Date;

public interface AvailabilityService {
    AvailabilityResult getAvailabilities(long startDate, long endDate);
    AvailabilityResult getAvailabilities();
}
