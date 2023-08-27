package com.joaogabriel.register.service;

import com.joaogabriel.register.dto.UserRegistrationDTO;
import com.joaogabriel.register.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private RegistrationRepository registrationRepository;

    public RegisterService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public Void registerNewUser(final UserRegistrationDTO payload) {
        registrationRepository.send(payload);
        return null;
    }
}
