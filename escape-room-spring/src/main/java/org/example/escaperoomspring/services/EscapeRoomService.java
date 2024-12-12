package org.example.escaperoomspring.services;

import org.example.escaperoomspring.builder.EscapeRoomBuild;
import org.example.escaperoomspring.models.Task;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Service;

@Service
public class EscapeRoomService {

    private final MqttService mqttService;

    public EscapeRoomService(MqttService mqttService) {
        this.mqttService = mqttService;
    }

    public void startGame() throws MqttException, InterruptedException {
        EscapeRoomBuild escapeRoom = new EscapeRoomBuild.EscapeRoomBuilder()
                .setWelcomeMessage("Welcome to the mysterious escape room adventure!")
                .setEscapeMessage("You've successfully escaped the room!")
                .addRoom("Entrance Hall", "A well-lit hall with displays on the wall.\n", 120)
                .addTask(1, "Find the Code", "Complete the sequence to unlock the door!", Task.taskType.LOGIC_PUZZLE, "The sequence is: 0, 1, 1, 2, 3, 5, 8, 13... What is the next number?", "orange")
                .addSolution("21")
                .addHint("The sequence is Fibonacci.")
                .finishTask()
                .addTask(2, "Light Memory Challenge", "Remember the light sequence carefully.", Task.taskType.LIGHT_PUZZLE, "Which color was displayed after blue?", "green")
                .lightColorSequence("blue", "green", "red")
                .addSolution("green")
                .addHint("color of grass")
                .finishTask()
                .finishRoom()
                .build();

        escapeRoom.validate();

        //mqttService.publishLightSequence(escapeRoom.getTasks().get(1).getLightSequence());
        //mqttService.publishSingleLight(escapeRoom.getCurrentRoom().getTasks().get(0).getSuccessColor());

        escapeRoom.play(this.mqttService);
    }
}

