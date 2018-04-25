package com.yvaldm.statistics.service;

import com.yvaldm.statistics.entity.Stats;
import com.yvaldm.statistics.entity.Transaction;
import com.yvaldm.statistics.entity.TransactionHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StatisticsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsService.class);
    private TransactionHolder[] tranactionHolders = new TransactionHolder[60];
    private Stats stats = new Stats();

    private StatisticsService() {
        for (int i = 0; i < 60; i++) {
            tranactionHolders[i] = new TransactionHolder();
        }

        new StatsShifter(this).start();
    }

    public void addTransactionNow(Transaction transaction) {
        LOGGER.info("adding transaction " + transaction);
        tranactionHolders[59].getTransactions().add(transaction);
    }

    public void shiftStats() {

        LOGGER.info("shifting stats");

        for (int i = 0; i < 59; i++) {
            tranactionHolders[i] = tranactionHolders[i + 1];
            System.out.print(String.format("%d", tranactionHolders[i].getTransactions().size()));
        }

        System.out.println();

        tranactionHolders[59] = new TransactionHolder();
    }

    public void recalculateStats() {

        LOGGER.info("recalculating stats");

        stats = new Stats();
        BigDecimal sum = BigDecimal.ZERO;
        int count = 0;

        for (int i = 0; i < 60; i++) {
            TransactionHolder transactionHolder = tranactionHolders[i];
            List<Transaction> transactions = transactionHolder.getTransactions();
            for (Transaction t : transactions) {
                sum = sum.add(t.getAmount());
                count++;
            }
        }

        stats.setSum(sum);
        stats.setCount(count);

        if (count != 0) {
            stats.setAvg(sum.divide(BigDecimal.valueOf(count)));
        }
    }

    public Stats getStatistics() {
        return stats;
    }
}
