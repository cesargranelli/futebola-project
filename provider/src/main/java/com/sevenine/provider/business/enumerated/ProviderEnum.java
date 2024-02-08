package com.sevenine.provider.business.enumerated;

import com.sevenine.provider.infrastructure.client.apidojo.PlayerApiDojoService;
import com.sevenine.provider.infrastructure.client.apidojo.TeamApiDojoService;
import com.sevenine.provider.infrastructure.client.apidojo.TeamApiSofascoreService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProviderEnum {
    APIDOJO_TEAM(TeamApiDojoService.class),
    APIDOJO_PLAYER(PlayerApiDojoService.class),
    SOFASCORE(TeamApiSofascoreService.class);

    private final Class<?> strategy;
}
