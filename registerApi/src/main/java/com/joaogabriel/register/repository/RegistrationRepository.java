package com.joaogabriel.register.repository;


import com.google.gson.Gson;
import com.joaogabriel.register.dto.UserRegistrationDTO;
import com.joaogabriel.register.producer.KafkaProducer;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepository {
    private KafkaProducer kafkaProducer;

    public RegistrationRepository(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    public void send(UserRegistrationDTO dto) {
        kafkaProducer.sendMessage(new Gson().toJson(dto));
    }
}

