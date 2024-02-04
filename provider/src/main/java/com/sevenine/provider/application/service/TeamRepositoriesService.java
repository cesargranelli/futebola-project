package com.sevenine.provider.application.service;

import com.sevenine.provider.business.entity.Team;

import java.util.List;

public interface TeamRepositoriesService {
    Team findBySlug(String slug);

    void save(List<Team> teams);
}
