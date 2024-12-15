//package org.example.escaperoomspring.services;
//
//import org.eclipse.paho.client.mqttv3.*;
//import org.example.escaperoomspring.interfaces.MqttServiceInterface;
//import org.springframework.stereotype.Service;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//@Service
//public class MqttService implements MqttServiceInterface {
//    private MqttClient client;
//
//    public MqttService() throws MqttException {
//        try {
//            String brokerUrl = "ssl://openlab.kpi.fei.tuke.sk:8883";
//            String clientId = "example-client-" + MqttClient.generateClientId();
//            client = new MqttClient(brokerUrl, clientId);
//
//            MqttConnectOptions options = new MqttConnectOptions();
//            options.setKeepAliveInterval(10);
//            options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);
//            options.setAutomaticReconnect(true);
//            options.setCleanSession(true);
//            options.setWill("example/test-client/java", (clientId + " disconnected").getBytes(), 0, false);
//
//            client.connect(options);
//            client.subscribe("example/test-client/java/messages", getMessageCallback());
//        } catch (Exception e) {
//            System.err.println("Error connecting to MQTT: " + e.getClass().getName() + ": " + e.getMessage());
//            if (e.getCause() != null) {
//                System.err.println(" - " + e.getCause().getClass().getName() + ": " + e.getCause().getMessage());
//            }
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static IMqttMessageListener getMessageCallback() {
//        return (topic, message) -> {
//            String msg = new String(message.getPayload(), StandardCharsets.UTF_8);
//            System.out.println(topic + " - " + msg);
//        };
//    }
//
//    @Override
//    public void connect() throws MqttException {
//        client.connect();
//    }
//
//    @Override
//    public void publish(String topic, String message) throws MqttException {
//        client.publish(topic, new MqttMessage(message.getBytes()));
//    }
//
//    public void publishLightSequence(List<String> lightSequence) throws MqttException, InterruptedException {
//        for (String color : lightSequence) {
//            publishSingleLight(color);
//            Thread.sleep(2000);
//        }
//    }
//
//    public void publishSingleLight(String lightColor) throws MqttException {
//        String color = ColorConverter.getColorCode(lightColor);
//        String topic = "openlab/lights";
//        String jsonString = "{\"all\": \"" + color + "00" + "\", \"duration\": 1000}";
//        byte[] payload = jsonString.getBytes();
//        MqttMessage message = new MqttMessage(payload);
//        client.publish(topic, message);
//    }
//
//    public static class ColorConverter {
//        public static String getColorCode(String colorName) {
//            switch (colorName.toLowerCase()) {
//                case "red": return "FF000000";
//                case "green": return "00FF0000";
//                case "orange": return "FF450000";
//                case "purple": return "RRGGBB00";
//                case "blue": return "0000FF00";
//                case "yellow": return "FFD70000";
//                case "pink": return "FF149300";
//                case "none": return "00000000";
//                case "win": return "B9724B29";
//                default: return "FFFFFFFF";
//            }
//        }
//    }
//}