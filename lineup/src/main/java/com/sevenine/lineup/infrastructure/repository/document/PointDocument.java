package com.sevenine.lineup.infrastructure.repository.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointDocument {
    private Integer assist;
    private Integer block;
    private Integer save;
    private Integer shot;
    private Integer goal;
    private Integer pass;
    private Integer punch;
    private Integer foul;
}
