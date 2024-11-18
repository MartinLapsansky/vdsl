package org.example.escaperoomspring.interfaces;


import org.example.escaperoomspring.models.Room;
import org.example.escaperoomspring.models.Task;

import java.util.List;

public interface EscapeRoom {
    EscapeRoom addRoom(Room room);
    void play();

    List<Task>getTasks();
}
