package com.bf1stats.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class BaseStatsController {

    @RequestMapping("baseStats")
    public String baseStats() {
        return "Hello World!";
    }
}
