package org.example.escaperoomspring.services;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.escaperoomspring.interfaces.MqttServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockMqttService implements MqttServiceInterface {

    @Override
    public void connect() throws MqttException {
        // Mockovaná implementácia
        System.out.println("Mock connect to MQTT broker.");
    }

    @Override
    public void publish(String topic, String message) throws MqttException {
        // Mockovaná implementácia
        System.out.println("Mock publish to topic " + topic + ": " + message);
    }

    @Override
    public void publishLightSequence(List<String> lightSequence) throws MqttException, InterruptedException {
        // Mockovaná implementácia
        System.out.println("Mock publish light sequence: " + lightSequence);
    }

    @Override
    public void publishSingleLight(String color) throws MqttException {
        // Mockovaná implementácia
        System.out.println("Mock publish single light: " + color);
    }
}