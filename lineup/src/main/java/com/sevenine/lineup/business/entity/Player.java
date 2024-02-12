package com.sevenine.lineup.business.entity;

import com.sevenine.lineup.business.enumerated.PositionNameEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String uuid;
    private String name;
    private String shortName;
    private PositionNameEnum position;
    private String shirtNumber;
    private Point points;
}
