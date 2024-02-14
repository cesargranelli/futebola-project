package com.sevenine.lineup.business.entity;

import com.sevenine.lineup.business.enumerated.StatusRoundEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Round {
    private String id;
    private String uuid;
    private Integer number;
    private String name;
    private String beginDateTime;
    private String endDateTime;
    private StatusRoundEnum status;
}
