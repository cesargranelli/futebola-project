package com.sevenine.provider.application.service;

import com.sevenine.provider.business.entity.Team;

import java.util.List;

public interface TeamRepository {
    Team findByIdOrigin(Long slug);

    void save(List<Team> teams);
}
