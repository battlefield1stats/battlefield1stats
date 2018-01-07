package com.bf1stats.api;

import com.bf1stats.domain.db.DetailedStatsDb;
import com.bf1stats.dao.DetailedStatsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class BaseStatsController {

    private static Logger LOGGER = LoggerFactory.getLogger(BaseStatsController.class);

    @Autowired
    private DetailedStatsDao detailedStatsDao;

    @RequestMapping("detailedStats")
    @ResponseBody
    public DetailedStatsDb detailedStats() {
        return detailedStatsDao.findFirstByOrderByRecordedDesc().orElse(new DetailedStatsDb());
    }
}
