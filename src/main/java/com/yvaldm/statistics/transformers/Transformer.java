package com.yvaldm.statistics.transformers;

import com.yvaldm.statistics.api.StatisticsResponse;
import com.yvaldm.statistics.api.TransactionRequest;
import com.yvaldm.statistics.entity.Stats;
import com.yvaldm.statistics.entity.Transaction;

public class Transformer {

    public static Transaction requestToTransaction(TransactionRequest request) {
        return new Transaction(request.getAmount(), request.getTimestamp());
    }

    public static StatisticsResponse statisticsToResponse(Stats statistics) {

        return new StatisticsResponse(statistics.getSum(), statistics.getAvg(), statistics.getMax(), statistics.getMin(), statistics.getCount());

    }
}
