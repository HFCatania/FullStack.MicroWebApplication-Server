package com.beansbeans.moneyapp.Services;

import com.beansbeans.moneyapp.Model.Account;
import com.beansbeans.moneyapp.Model.Transaction;
import com.beansbeans.moneyapp.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beansbeans.moneyapp.Repositories.AccountRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class TransactionService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public Transaction newTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction findTransactionById(Long id){
        return transactionRepository.findById(id).get();
    }

    public Iterable<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Transaction findTransactionByUserId(Long userId) {
        return transactionRepository.findById(userId).get(); }

    public Boolean depositTo(Long id, Double amount){
        Account account = accountRepository.findById(id).get();
        Double initialBalance = account.getBalance();
        account.setBalance(initialBalance + amount);
        accountRepository.save(account);
//        transactionRepository.save()
        return true;
    }

    public Boolean withdrawFrom(Transaction transaction){
        Long id = transaction.getFromAccountId();
        Double amount = transaction.getAmount();
        Account account = accountRepository.findById(id).get();
        Double initialBalance = account.getBalance();
        if((initialBalance - amount) < 0.0){
            throw new IllegalArgumentException("Unable to complete Transaction.  Insufficient Funds");
        }
        account.setBalance(initialBalance - amount);
        accountRepository.save(account);
        Transaction logTransaction = new Transaction(transaction.getFromAccountId(), null,
                transaction.getAmount(), transaction.getMemo(), LocalDateTime.now(), transaction.getUserId());
        transactionRepository.save(logTransaction);
        return true;
    }

    public Boolean transferFunds(Long fromId, Long toId, Double amount){
        Account fromAccount = accountRepository.findById(fromId).get();
        Account toAccount = accountRepository.findById(toId).get();
        Double initialBalance = fromAccount.getBalance();
        Double initialBalance2 = toAccount.getBalance();
        if((initialBalance - amount) < 0.00){
            throw new IllegalArgumentException("Unable to complete Transaction.  Insufficient Funds");
        }
        fromAccount.setBalance(initialBalance - amount);
        toAccount.setBalance(initialBalance2 + amount);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        return true;
    }

    public Iterable<Transaction> findAllByUserId(Long userId){
        return transactionRepository.findAllByUserId(userId);
    }
}
