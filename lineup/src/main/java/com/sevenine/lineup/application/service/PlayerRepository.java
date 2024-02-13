package com.sevenine.lineup.application.service;

import com.sevenine.lineup.business.entity.Player;
import com.sevenine.lineup.business.enumerated.PositionEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlayerRepository {
    Page<Player> list(Pageable pageable);

    Page<Player> list(Pageable pageable, PositionEnum position);
}
