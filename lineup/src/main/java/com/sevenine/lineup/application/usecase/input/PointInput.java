package com.sevenine.lineup.application.usecase.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PointInput(int assist, int block, int save, int shot, int goal, int pass, int punch, int foul) {
}
