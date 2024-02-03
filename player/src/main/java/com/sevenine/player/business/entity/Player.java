package com.sevenine.player.business.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static java.util.Objects.isNull;

@Getter
@Setter
public class Player {
    private String uuid;
    private String idOrigin;
    private String name;
    private String shortName;
    private String position;
    private String shirtName;

    public Player generatedUuid() {
        this.uuid = (isNull(uuid)) ? UUID.randomUUID().toString() : this.uuid;
        return this;
    }
}
