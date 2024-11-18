package org.example.escaperoomspring.controllers;

import org.example.escaperoomspring.services.MqttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mqtt")
public class MqttController {

    @Autowired
    public MqttController(MqttService mqttService) {
    }

}

