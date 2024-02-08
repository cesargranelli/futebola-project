package com.sevenine.provider.application.strategy;

import com.sevenine.provider.application.service.TeamApiService;
import com.sevenine.provider.application.service.response.TeamResponse;
import com.sevenine.provider.business.enumerated.ProviderEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TeamApiContextStrategy {

    private final ApplicationContext context;

    private TeamApiService service;

    public List<TeamResponse> execute(String tournamentCode, String seasonCode) {
        return service.list(tournamentCode, seasonCode);
    }

    public TeamApiContextStrategy withProvider(ProviderEnum provider) {
        service = (TeamApiService) context.getBean(provider.getStrategy());

        return this;
    }

}
