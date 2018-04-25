package com.yvaldm.statistics.entity;

import java.util.ArrayList;
import java.util.List;

public class TransactionHolder {

    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
