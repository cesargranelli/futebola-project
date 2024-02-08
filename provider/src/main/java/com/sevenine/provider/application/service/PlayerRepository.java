package com.sevenine.provider.application.service;

import com.sevenine.provider.business.entity.Player;

import java.util.List;

public interface PlayerRepository {
    Player findByIdOrigin(Long idOrigin);

    void save(List<Player> players);
}
