package com.sevenine.auth.business.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

import static java.util.Objects.isNull;

@Getter
@Setter
public class User {
    private String uuid;
    private String name;
    private String nick;
    private LocalDate birthdate;
    private Credential credentials;
    private Contact contacts;
    private Team team;

    public User generatedUuid() {
        this.uuid = (isNull(uuid)) ? UUID.randomUUID().toString() : this.uuid;
        return this;
    }
}
