package com.sevenine.provider.infrastructure.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("rapidapi.apidojo")
public class ApiDojoProperties {
    private Endpoints endpoints;
    private Credentials credentials;

    @Getter
    @Setter
    public static class Endpoints {
        private String getStandings;
    }

    @Getter
    @Setter
    public static class Credentials {
        private String xRapidapiHost;
        private String xRapidapiKey;
    }
}
