package com.beansbeans.moneyapp.Model;

import java.time.LocalDateTime;

public class DepositTransaction {
    private Long transactionId;
    private Long toAccountId;
    private Double amount;
    private String memo;
    private LocalDateTime localDateTime;
    private Long userId;

    public DepositTransaction() { }

    public DepositTransaction( Long toAccountId, Double amount, String memo, LocalDateTime localDateTime, Long userId) {
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = localDateTime;
        this.userId = userId;
    }

    public DepositTransaction(Long transactionId, Long toAccountId, Double amount, String memo, LocalDateTime localDateTime, Long userId) {
        this.transactionId = transactionId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = localDateTime;
        this.userId = userId;
    }

    public DepositTransaction(Long toAccountId, Double amount, String memo, Long userId){
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = LocalDateTime.now();
        this.userId = userId;
    }

    public DepositTransaction(Long toAccountId, Double amount) {
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getUserId(){ return userId; }

    public void setUserId(Long userId){ this.userId = userId; }
}
