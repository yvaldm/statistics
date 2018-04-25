package com.yvaldm.statistics.controller;

import com.yvaldm.statistics.api.TransactionRequest;
import com.yvaldm.statistics.service.StatisticsService;
import com.yvaldm.statistics.transformers.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping
    public void newTransaction(@RequestBody TransactionRequest request) {
        statisticsService.addTransactionNow(Transformer.requestToTransaction(request));
    }

}
