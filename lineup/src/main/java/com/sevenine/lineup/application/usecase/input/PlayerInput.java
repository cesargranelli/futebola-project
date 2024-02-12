package com.sevenine.lineup.application.usecase.input;

import com.sevenine.lineup.business.enumerated.PositionNameEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record PlayerInput(@NotEmpty String uuid, @NotEmpty String name, @NotEmpty String shortName,
                          @Schema(allowableValues = {
                                  "GOALKEEPER", "DEFENDER", "MIDFIELDER", "FORWARD", "ALL"
                          }) PositionNameEnum position,
                          @NotEmpty String shirtNumber, PointInput points) {
}
