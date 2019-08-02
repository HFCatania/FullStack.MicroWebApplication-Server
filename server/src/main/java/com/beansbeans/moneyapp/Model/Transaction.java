package com.beansbeans.moneyapp.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
    private String memo;
    private LocalDateTime localDateTime;
    private Long userId;
    private boolean isActive;

    public Transaction() { }

    public Transaction(Long fromAccountId, Long toAccountId, Double amount, String memo, LocalDateTime localDateTime, Long userId, boolean isActive) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = localDateTime;
        this.userId = userId;
        this.isActive = isActive;
    }

    public Transaction(Long transactionId, Long fromAccountId, Long toAccountId, Double amount, String memo, LocalDateTime localDateTime, Long userId, boolean isActive) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = localDateTime;
        this.userId = userId;
        this.isActive = isActive;
    }

    public Transaction(Long fromAccountId, Long toAccountId, Double amount, String memo, Long userId, boolean isActive){
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = LocalDateTime.now();
        this.userId = userId;
        this.isActive = isActive;
    }

    public Transaction(Long toAccountId, Double amount, boolean isActive) {
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.isActive = isActive;
    }

    public Transaction(Long fromAccountId, String memo, boolean isActive) {
        this.fromAccountId = fromAccountId;
        this.memo = memo;
        this.isActive = isActive;
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

    public boolean isActive() { return isActive; }

    public void setActive(boolean active) { isActive = active; }
}
