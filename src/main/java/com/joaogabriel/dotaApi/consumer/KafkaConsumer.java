package com.joaogabriel.dotaApi.consumer;

import com.google.gson.Gson;
import com.joaogabriel.dotaApi.dto.user.UserRegistrationDTO;
import com.joaogabriel.dotaApi.service.RegisterService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private RegisterService registrationService;

    public KafkaConsumer(RegisterService registerService) {
        this.registrationService = registerService;
    }
    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void listener(@Payload String data) {
        try {
            UserRegistrationDTO userDto = new Gson().fromJson(data, UserRegistrationDTO.class);
            if(userDto != null) {
                registrationService.registerNewUser(userDto);
            }
        }
        catch (Exception ex) {
        }
    }
}
