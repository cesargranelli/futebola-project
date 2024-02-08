package com.sevenine.auth.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.auth.application.service.UserService;
import com.sevenine.auth.application.usecase.input.SignupInput;
import com.sevenine.auth.application.usecase.output.SignupOutput;
import com.sevenine.auth.business.entity.Credential;
import com.sevenine.auth.business.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SignupUsecase {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final ObjectMapper mapper;

    public SignupOutput create(SignupInput input) {
        Credential credential = new Credential();
        credential.setUsername(input.email());
        credential.setPassword(passwordEncoder.encode(input.password()));

        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setName(input.name());
        user.setNick(input.email());
        user.setBirthdate(input.birthdate());
        user.setCredentials(credential);

        User response = userService.create(user);

        return new SignupOutput(response.getUuid(), "OK");
    }

}
