package com.sevenine.player.application.usecase.output;

import com.sevenine.player.business.enumerated.PositionAcronymEnum;

public record PlayerOutput(String uuid, String name, String shortName, PositionAcronymEnum position,
                           String shirtNumber) {
    public String getPosition() {
        return position.getName();
    }
}
