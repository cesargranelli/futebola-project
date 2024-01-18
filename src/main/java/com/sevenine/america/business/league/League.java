package com.sevenine.america.business.league;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static java.util.Objects.isNull;

@Getter
@Setter
public class League {
    private String uuid;
    private String city;
    private String name;
    private String nick;

    public void setUuid(String uuid) {
        if (isNull(uuid)) {
            this.uuid = UUID.randomUUID().toString();
        } else {
            this.uuid = uuid;
        }
    }
}
