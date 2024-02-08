package com.sevenine.provider.application.service;

import com.sevenine.provider.application.service.response.TeamResponse;

import java.util.List;

public interface TeamApiService {
    List<TeamResponse> list(String... strings);
}
