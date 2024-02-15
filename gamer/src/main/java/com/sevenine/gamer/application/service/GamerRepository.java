package com.sevenine.gamer.application.service;

import com.sevenine.gamer.business.entity.Gamer;

public interface GamerRepository {
    Gamer save(Gamer newGamer);

    Gamer findByUuid(String uuid);

    Gamer findByUuidUser(String uuidUser);
}
