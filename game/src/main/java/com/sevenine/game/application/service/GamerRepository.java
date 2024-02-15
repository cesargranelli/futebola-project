package com.sevenine.game.application.service;

import com.sevenine.game.business.entity.Gamer;

public interface GamerRepository {
    Gamer save(Gamer newGamer);

    Gamer findByUuid(String uuid);

    Gamer findByUuidUser(String uuidUser);
}
