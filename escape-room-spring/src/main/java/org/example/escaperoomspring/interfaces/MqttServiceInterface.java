package org.example.escaperoomspring.interfaces;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface MqttServiceInterface {
    void connect() throws MqttException;
    void publish(String topic, String message) throws MqttException;
    void publishLightSequence(java.util.List<String> lightSequence) throws MqttException, InterruptedException;
    void publishSingleLight(String color) throws MqttException;
}