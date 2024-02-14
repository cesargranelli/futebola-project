package com.sevenine.lineup.business.rules.lineup;

import com.sevenine.lineup.business.entity.Lineup;

public interface LineupValidationRules {
    void execute(Lineup lineup);
}
