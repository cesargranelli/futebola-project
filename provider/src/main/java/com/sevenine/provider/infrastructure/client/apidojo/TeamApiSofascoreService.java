package com.sevenine.provider.infrastructure.client.apidojo;

import com.sevenine.provider.application.service.TeamApiService;
import com.sevenine.provider.application.service.response.TeamResponse;
import com.sevenine.provider.infrastructure.client.apidojo.converter.TeamApiDojoConverter;
import com.sevenine.provider.infrastructure.properties.ApiDojoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamApiSofascoreService implements TeamApiService {

    private final ApiDojoProperties properties;
    private final RestTemplate restTemplate;
    private final TeamApiDojoConverter converter;

    @Override
    public List<TeamResponse> list(String... strings) {
        System.out.println("TeamApiSofascoreService.list");
//        String endpoint = properties.getGetStadings()
//                .concat("?tournamentId=").concat(tournamentCode)
//                .concat("&seasonId=").concat(seasonCode)
//                .concat("&type=total");
//
//        ResponseEntity<TotalApiDojo> responseEntity =
//                restTemplate.exchange(requestEntity(endpoint), TotalApiDojo.class);
//
//        if (!responseEntity.getStatusCode().is2xxSuccessful() || isNull(responseEntity.getBody())) {
//            return null;
//        }

        return null;//converter.convert(responseEntity.getBody());
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
