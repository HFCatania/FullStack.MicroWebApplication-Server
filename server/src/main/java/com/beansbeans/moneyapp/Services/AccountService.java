package com.beansbeans.moneyapp.Services;

import com.beansbeans.moneyapp.Model.Account;
import com.beansbeans.moneyapp.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account create(Account account){
        return accountRepository.save(account);
    }

    public Account show(Long id){
        return accountRepository.findById(id).get();
    }

    public Account updateBalance(Long id, Account newAccountData){
        Account originalAccount = accountRepository.findById(id).get();
        originalAccount.setBalance(newAccountData.getBalance());
        return accountRepository.save(originalAccount);
    }

    public Boolean deleteAccount(Long id){
        accountRepository.deleteById(id);
        return true;
    }


}
