package fr.mines.ales.rest.hotel;

import fr.mines.ales.rest.hotel.repositories.FlyRepository;

public abstract class ApplicationProvider {
    private static FlyRepository flyRepository;

    static void setFlyRepository(FlyRepository flyRepository){
        ApplicationProvider.flyRepository = flyRepository;
    }

    public static FlyRepository getFlyRepository(){
        return flyRepository;
    }
}
