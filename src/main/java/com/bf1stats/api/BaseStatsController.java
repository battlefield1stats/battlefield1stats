package com.bf1stats.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class BaseStatsController {

    private static Logger LOGGER = LoggerFactory.getLogger(BaseStatsController.class);

    @Value("${trn.api.token}")
    private String trnApiToken;

    @RequestMapping("baseStats")
    public String baseStats() {
        LOGGER.info(System.getProperty("trn.api.token"));
        return "Hello World!" + trnApiToken;
    }
}
