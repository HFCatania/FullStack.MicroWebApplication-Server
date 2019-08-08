package com.beansbeans.moneyapp.Model;

import java.time.LocalDateTime;


public class WithdrawTransaction {
    private Long transactionId;
    private Long fromAccountId;
    private Double amount;
    private String memo;
    private LocalDateTime localDateTime;
    private Long userId;

    public WithdrawTransaction() { }

    public WithdrawTransaction(Long fromAccountId, Double amount, String memo, LocalDateTime localDateTime, Long userId) {
        this.fromAccountId = fromAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = localDateTime;
        this.userId = userId;
    }

    public WithdrawTransaction(Long transactionId, Long fromAccountId, Double amount, String memo, LocalDateTime localDateTime, Long userId) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = localDateTime;
        this.userId = userId;
    }

    public WithdrawTransaction(Long fromAccountId, Double amount, String memo, Long userId){
        this.fromAccountId = fromAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = LocalDateTime.now();
        this.userId = userId;
    }

    public WithdrawTransaction(Long fromAccountId, String memo) {
        this.fromAccountId = fromAccountId;
        this.memo = memo;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
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
