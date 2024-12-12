package org.example.escaperoomspring.interfaces;


import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.escaperoomspring.models.Room;
import org.example.escaperoomspring.models.Task;
import org.example.escaperoomspring.services.MqttService;

import java.util.List;

public interface EscapeRoom {
    EscapeRoom addRoom(Room room);
    void play(MqttService mqttService) throws MqttException, InterruptedException;

    List<Task>getTasks();
}
