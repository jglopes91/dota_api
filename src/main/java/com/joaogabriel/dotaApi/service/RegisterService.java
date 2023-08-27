package com.joaogabriel.dotaApi.service;

import com.joaogabriel.dotaApi.dto.user.UserRegistrationDTO;
import com.joaogabriel.dotaApi.entity.UserEntity;
import com.joaogabriel.dotaApi.repository.RegistrationRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private RegistrationRepository registrationRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public RegisterService(RegistrationRepository registrationRepository, BCryptPasswordEncoder passwordEncoder) {
        this.registrationRepository = registrationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Void registerNewUser(final UserRegistrationDTO payload) {
        String encryptPassword = passwordEncoder.encode(payload.getPassword());
        UserEntity user = payload.toUserEntity(encryptPassword);
        registrationRepository.save(user);
        return null;
    }
}
