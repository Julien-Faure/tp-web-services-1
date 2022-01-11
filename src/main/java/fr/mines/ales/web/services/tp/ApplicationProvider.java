package fr.mines.ales.web.services.tp;

import fr.mines.ales.web.services.tp.repositories.RoomRepository;

public abstract class ApplicationProvider {
    private static RoomRepository roomRepository;

    public static RoomRepository getRoomRepository() {
        return roomRepository;
    }

    static void setRoomRepository(RoomRepository roomRepository) {
        ApplicationProvider.roomRepository = roomRepository;
    }
}
