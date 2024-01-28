package com.sevenine.auth.client.business;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

import static java.util.Objects.isNull;

@Getter
@Setter
public class Client {
    private String uuid;
    private String name;
    private String document;
    private LocalDate birthdate;

    public Client generatedUuid() {
        this.uuid = (isNull(uuid)) ? UUID.randomUUID().toString() : this.uuid;
        return this;
    }
}
