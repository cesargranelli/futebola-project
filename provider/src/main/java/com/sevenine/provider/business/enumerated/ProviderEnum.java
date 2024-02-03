package com.sevenine.provider.business.enumerated;

import com.sevenine.provider.infrastructure.client.apidojo.TeamApiDojoService;
import com.sevenine.provider.infrastructure.client.apidojo.TeamApiSofascoreService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProviderEnum {
    APIDOJO(TeamApiDojoService.class), SOFASCORE(TeamApiSofascoreService.class);

    private final Class<?> strategy;
}
