package com.sevenine.player.application.service;

import com.sevenine.player.business.entity.Player;
import com.sevenine.player.business.enumerated.PositionNameEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlayerRepository {
    Page<Player> listAllPlayers(Pageable pageable);

    Page<Player> listAllPlayersByPosition(Pageable pageable, PositionNameEnum position);
}