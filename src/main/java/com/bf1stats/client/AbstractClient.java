package com.bf1stats.client;

import com.bf1stats.domain.RootMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

public abstract class AbstractClient {

    @Value("${user}")
    private String user;

    @Value("${platform}")
    private String platform;

    @Value("${game}")
    private String game;

    @Autowired
    private RestTemplate trnRestTemplate;

    private String uri;

    abstract String getResource();

    @PostConstruct
    public void initUri() {
        uri = "/" + getResource() +
                "?platform=" + platform +
                "&displayName=" + user +
                "&game=" + game;
    }

    public <T extends RootMarker> T getFromResource(Class<T> clazz) {
        return trnRestTemplate.getForObject(uri, clazz);
    }
}
