package com.sevenine.provider.infrastructure.client.apidojo;

import com.sevenine.provider.application.service.TeamApiService;
import com.sevenine.provider.application.service.response.TeamResponse;
import com.sevenine.provider.infrastructure.client.apidojo.converter.TeamApiDojoConverter;
import com.sevenine.provider.infrastructure.client.apidojo.response.TotalApiDojo;
import com.sevenine.provider.infrastructure.properties.RapidApiProperties;
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
public class TeamApiDojoService implements TeamApiService {

    private final RapidApiProperties properties;
    private final RestTemplate restTemplate;
    private final TeamApiDojoConverter converter;

    @Override
    public List<TeamResponse> list(String tournamentCode, String seasonCode) {
        String endpoint = properties.getGetStadings()
                .concat("?tournamentId=").concat(tournamentCode)
                .concat("&seasonId=").concat(seasonCode)
                .concat("&type=total");

        ResponseEntity<TotalApiDojo> responseEntity =
                restTemplate.exchange(requestEntity(endpoint), TotalApiDojo.class);

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
        httpHeaders.add("x-rapidapi-host", properties.getXRapidapiHost());
        httpHeaders.add("x-rapidapi-key", properties.getXRapidapiKey());

        return httpHeaders;
    }

}
