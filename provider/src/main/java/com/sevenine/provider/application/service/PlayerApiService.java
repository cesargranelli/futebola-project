package com.sevenine.provider.application.service;

import com.sevenine.provider.application.service.response.PlayerResponse;

import java.util.List;

public interface PlayerApiService {
    List<PlayerResponse> list(Object... objects);
}
