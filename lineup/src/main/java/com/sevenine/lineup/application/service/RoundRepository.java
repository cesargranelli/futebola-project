package com.sevenine.lineup.application.service;

import com.sevenine.lineup.business.entity.Round;
import com.sevenine.lineup.business.enumerated.StatusRoundEnum;

import java.util.List;

public interface RoundRepository {
    List<Round> findByStatus(StatusRoundEnum status);
}
