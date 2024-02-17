package com.sevenine.lineup.application.service;

import com.sevenine.lineup.business.entity.Lineup;

public interface LineupRepository {
    Lineup save(Lineup newLineup);
}
