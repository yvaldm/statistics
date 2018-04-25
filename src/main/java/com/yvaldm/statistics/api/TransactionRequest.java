package com.yvaldm.statistics.api;

import java.math.BigDecimal;

public class TransactionRequest {

    private BigDecimal amount;
    private long timestamp;

    public BigDecimal getAmount() {
        return amount;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
