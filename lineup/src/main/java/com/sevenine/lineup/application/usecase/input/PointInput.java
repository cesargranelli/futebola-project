package com.sevenine.lineup.application.usecase.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PointInput(double assist, double block, double save, double shot, double goal, double pass,
                         double punch, double foul) {
}
