package Interfaces;

import model.Room;

public interface EscapeRoom {
    EscapeRoom addRoom(Room room);//hra moze mat viac Rooms
    void play();
}
