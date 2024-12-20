package org.example.escaperoomspring.services;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class MqttService {
    private MqttClient client;

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
            //System.out.println("MQTT Client connected.");

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

    public void publishLightSequence(List<String> lightSequence) throws MqttException, InterruptedException {
        System.out.println("mqttserv lightSequence: " + lightSequence);

        for (String color : lightSequence) {
            //client.publish("openlab/lights", new MqttMessage(color.getBytes()));
            publishSingleLight(color);
            System.out.println("mqttserv pub seq Sent color: " + color);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
        }
    }

    public class ColorConverter {

        public static String getColorCode(String colorName) {
            colorName = colorName.toLowerCase();

            String colorCode = "";
            switch (colorName) {
                case "red":
                    colorCode = "FF000000";
                    break;
                case "green":
                    colorCode = "00FF0000";
                    break;
                case "orange":
                    colorCode = "FF450000";
                    break;
                case "purple":
                    colorCode = "19003300";
                    break;
                case "blue":
                    colorCode = "0000FF00";
                    break;
                case "yellow":
                    colorCode = "FFD70000";
                    break;
                case "pink":
                    colorCode = "CC006600";
                    break;
                case "none":
                    colorCode = "00000000";
                    break;
                case "win":
                    colorCode = "B9724B29";
                default:
                    colorCode = "FFFFFFFF";
                    break;
            }

            return colorCode;
        }
    }

    public void publishSingleLight(String lightColor) throws MqttException {
        ColorConverter colorConv = new ColorConverter();
        System.out.println("\n mqttserv light color " + lightColor);
        String color = colorConv.getColorCode(lightColor);//"9932CC";
        String topic = "openlab/lights";

        String jsonString = "{\"all\": \"" + color + "00" + "\", \"duration\": 1000}";
        //String jsonString = "{\"all\": \"" + "00000000" + "\", \"duration\": 2000}";
        //String jsonString = "{\"all\": \"" + color + "00" + "\"}";

        byte[] payload = jsonString.getBytes();
        MqttMessage message = new MqttMessage(payload);
        client.publish(topic, message);
    }


}
