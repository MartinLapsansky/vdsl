//package org.example.escaperoomspring;
//
//import org.example.escaperoomspring.services.EscapeRoomService;
//import org.eclipse.paho.client.mqttv3.MqttException;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class GameRunner implements CommandLineRunner {
//
//    private final EscapeRoomService escapeRoomService;
//
//    public GameRunner(EscapeRoomService escapeRoomService) {
//        this.escapeRoomService = escapeRoomService;
//    }
//
//    @Override
//    public void run(String... args) throws MqttException, InterruptedException {
//        escapeRoomService.startGame();
//    }
//}
