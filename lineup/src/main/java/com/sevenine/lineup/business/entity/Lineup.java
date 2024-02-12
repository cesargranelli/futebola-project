package com.sevenine.lineup.business.entity;

import com.sevenine.lineup.business.enumerated.FormationEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Lineup {
    private FormationEnum formationEnum;
    private String userUuid;
    private Integer roundNumber;
    private List<Player> players;
    private List<Player> reserves;
    private final Integer totalPlayers = 11;
    private final Integer totalReserves = 3;

    public void validQuantityPlayers() {
        if (this.players.size() != this.totalPlayers) {
            throw new RuntimeException("Número de jogadores titulares inválido!");
        }

        if (this.reserves.size() != this.totalReserves) {
            throw new RuntimeException("Número de jogadores reservas inválido!");
        }
    }
}
