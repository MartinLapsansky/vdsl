package org.example.escaperoomspring.services;

import org.example.escaperoomspring.builder.EscapeRoomBuild;
import org.example.escaperoomspring.models.Task;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Service;

@Service
public class EscapeRoomService {

    //private final MqttService mqttService;

    /*public EscapeRoomService(MqttService mqttService) {
        this.mqttService = mqttService;
    }*/

    public void startGame() throws MqttException {
        EscapeRoomBuild escapeRoom = new EscapeRoomBuild.EscapeRoomBuilder()
                .setWelcomeMessage("Welcome to the mysterious escape room adventure!")
                .setEscapeMessage("You've successfully escaped the room!")
                .addRoom("Entrance Hall", "Dark hall with ancient paintings on the wall.", 120)
                .addTask(1, "Find the Code", "Complete the sequence to unlock the door!", Task.taskType.LOGIC_PUZZLE, "The sequence is: 0, 1, 1, 2, 3, 5, 8, 13... What is the next number?", "Red")
                .addSolution("21")
                .addHint("The sequence is Fibonacci.")
                .finishTask()
                .addTask(2, "Light Memory Challenge", "Remember the light sequence carefully.", Task.taskType.LIGHT_PUZZLE, "Which of the color was displayed after the red?", "Green")
                .lightColorSequence("Red", "Green", "Blue")
                .addSolution("green")
                .addHint("color of grass")
                .finishTask()
                .finishRoom()
                .build();

        escapeRoom.validate();

        //mqttService.publishLightSequence(escapeRoom.getTasks().get(1).getLightSequence());

        escapeRoom.play();
    }
}

