package com.sevenine.player.application.service;

import com.sevenine.player.business.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlayerRepository {
    Page<Player> listPlayers(Pageable pageable);
}
