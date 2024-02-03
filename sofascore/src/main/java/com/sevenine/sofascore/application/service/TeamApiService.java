package com.sevenine.sofascore.application.service;

import com.sevenine.sofascore.application.service.response.TeamResponse;

import java.util.List;

public interface TeamApiService {
    List<TeamResponse> list(String tournamentCode, String seasonCode);
}
