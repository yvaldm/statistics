package com.yvaldm.statistics.controller;

import com.yvaldm.statistics.api.StatisticsResponse;
import com.yvaldm.statistics.service.StatisticsService;
import com.yvaldm.statistics.transformers.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public StatisticsResponse getStatistics() {
        return Transformer.statisticsToResponse(statisticsService.getStatistics());
    }

}
