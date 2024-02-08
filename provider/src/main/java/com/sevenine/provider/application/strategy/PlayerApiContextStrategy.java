package com.sevenine.provider.application.strategy;

import com.sevenine.provider.application.service.PlayerApiService;
import com.sevenine.provider.application.service.response.PlayerResponse;
import com.sevenine.provider.business.enumerated.ProviderEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PlayerApiContextStrategy {

    private final ApplicationContext context;

    private PlayerApiService service;

    public List<PlayerResponse> execute(Object teamId) {
        return service.list(teamId);
    }

    public PlayerApiContextStrategy withProvider(ProviderEnum provider) {
        service = (PlayerApiService) context.getBean(provider.getStrategy());

        return this;
    }

}
