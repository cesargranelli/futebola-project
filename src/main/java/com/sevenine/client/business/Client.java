package com.sevenine.client.business;

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

    public void setUuid(String uuid) {
        if (isNull(uuid)) {
            this.uuid = UUID.randomUUID().toString();
        } else {
            this.uuid = uuid;
        }
    }
}
