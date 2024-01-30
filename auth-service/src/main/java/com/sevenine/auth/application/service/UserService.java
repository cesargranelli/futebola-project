package com.sevenine.auth.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.auth.business.entity.User;
import com.sevenine.auth.infrastructure.repository.document.UserDocument;
import com.sevenine.auth.infrastructure.repository.mongodb.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final ClientRepository repository;

    private final ObjectMapper mapper;

    public User create(User newUser) {
        User user = findUser(newUser.getCredentials().getUsername());
        if (isNull(user.getUuid())) {
            UserDocument userDocument = mapper.convertValue(newUser, UserDocument.class);
            return mapper.convertValue(repository.save(userDocument), User.class);
        }
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(newUser.getCredentials().getUsername()).password(newUser.getCredentials().getPassword());
        UserDetails build = userBuilder.build();
        return mapper.convertValue(user, User.class);
    }

    public User findUser(String username) {
        Optional<UserDocument> optional = repository.findByCredentialsUsername(username);

        User user = new User();
        if (optional.isPresent()) {
            user.setUuid(optional.get().getUuid());
            user.setName(optional.get().getName());
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
