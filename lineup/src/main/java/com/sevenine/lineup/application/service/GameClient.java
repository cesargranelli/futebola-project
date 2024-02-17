package com.sevenine.lineup.application.service;

import com.sevenine.lineup.business.entity.Gamer;

public interface GameClient {
    Gamer findGamerByUser(String uuidUser);
}
