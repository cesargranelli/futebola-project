package com.sevenine.provider.infrastructure.client.apidojo;

import com.sevenine.provider.application.service.PlayerApiService;
import com.sevenine.provider.application.service.response.PlayerResponse;
import com.sevenine.provider.infrastructure.client.apidojo.converter.PlayerApiDojoConverter;
import com.sevenine.provider.infrastructure.client.apidojo.converter.TeamApiDojoConverter;
import com.sevenine.provider.infrastructure.client.apidojo.response.SquadApiDojo;
import com.sevenine.provider.infrastructure.client.apidojo.response.TotalApiDojo;
import com.sevenine.provider.infrastructure.properties.ApiDojoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class PlayerApiDojoService implements PlayerApiService {

    private final ApiDojoProperties properties;
    private final RestTemplate restTemplate;
    private final PlayerApiDojoConverter converter;

    @Override
    public List<PlayerResponse> list(Object... objects) {
        String endpoint = properties.getEndpoints().getGetSquad()
                .concat("?teamId=").concat(String.valueOf(objects[0]));

        ResponseEntity<SquadApiDojo> responseEntity =
                restTemplate.exchange(requestEntity(endpoint), SquadApiDojo.class);

        if (!responseEntity.getStatusCode().is2xxSuccessful() || isNull(responseEntity.getBody())) {
            return null;
        }

        return converter.convert(responseEntity.getBody());
    }

    private RequestEntity<?> requestEntity(String endpoint) {
        return new RequestEntity<>(httpHeaders(), HttpMethod.GET, URI.create(endpoint));
    }

    private HttpHeaders httpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-rapidapi-host", properties.getCredentials().getXRapidapiHost());
        httpHeaders.add("x-rapidapi-key", properties.getCredentials().getXRapidapiKey());

        return httpHeaders;
    }

}
