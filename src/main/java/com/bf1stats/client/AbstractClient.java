package com.bf1stats.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

public abstract class AbstractClient <T> {

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

    abstract Class<T> getTargetClass();

    @PostConstruct
    public void initUri() {
        uri = "/" + getResource() +
                "?platform=" + platform +
                "&displayName=" + user +
                "&game=" + game;
    }

    public T getFromResource() {
        return trnRestTemplate.getForObject(uri, getTargetClass());
    }
}
