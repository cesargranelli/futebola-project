package com.sevenine.lineup.business.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Point {
    private int assist;
    private int block;
    private int save;
    private int shot;
    private int goal;
    private int pass;
    private int punch;
    private int foul;

    public Integer getTotalPoints() {
        return Arrays.stream(Point.class.getDeclaredFields()).toList().stream()
                .mapToInt(field -> {
                    try {
                        return field.getInt(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).reduce(Integer::sum).orElse(0);
    }
}
