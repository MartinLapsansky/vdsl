package org.example.escaperoomspring.services;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class MqttService {
    /*private MqttClient client;

    public MqttService() throws MqttException {
        try {
            String brokerUrl = "ssl://openlab.kpi.fei.tuke.sk:8883";
            String clientId = "example-client-" + MqttClient.generateClientId();
            client = new MqttClient(brokerUrl, clientId);

            MqttConnectOptions options = new MqttConnectOptions();
            options.setKeepAliveInterval(10);
            options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setWill("example/test-client/java", (clientId + " disconnected").getBytes(), 0, false);

            client.connect(options);
            System.out.println("MQTT Client connected.");

            client.subscribe("example/test-client/java/messages", getMessageCallback());
        } catch (Exception e) {
            System.err.println("Error connecting to MQTT: " + e.getClass().getName() + ": " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println(" - " + e.getCause().getClass().getName() + ": " + e.getCause().getMessage());
            }
            throw new RuntimeException(e);
        }
    }

    private static IMqttMessageListener getMessageCallback() {
        return (topic, message) -> {
            String msg = new String(message.getPayload(), StandardCharsets.UTF_8);
            System.out.println(topic + " - " + msg);
        };
    }

    public void publishLightSequence(List<String> lightSequence) throws MqttException {
        for (String color : lightSequence) {
            client.publish("openlab/lights", new MqttMessage(color.getBytes()));
            System.out.println("Sent color: " + color);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/


}
