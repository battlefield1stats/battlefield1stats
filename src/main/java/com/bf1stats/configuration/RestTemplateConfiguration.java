package com.bf1stats.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    private static final String TRN_API_HEADER = "TRN-Api-Key";
    private static final String TRN_ROOT_URL = "https://battlefieldtracker.com/bf1/api";

    @Value("${trn.api.token}")
    private String trnApiToken;

    @Bean
    public RestTemplate trnRestTemplate(RestTemplateBuilder builder) {
        return builder
                .interceptors((ClientHttpRequestInterceptor) (request, body, execution) -> {
                    HttpHeaders headers = request.getHeaders();
                    headers.set(TRN_API_HEADER, trnApiToken);
                    headers.set("User-Agent", "curl/7.37.0"); // java user agent is banned by trn :(
                    return execution.execute(request, body);
                })
                .rootUri(TRN_ROOT_URL)
                .build();
    }
}
