package com.beansbeans.moneyapp.Controllers;

import com.beansbeans.moneyapp.Model.Account;
import com.beansbeans.moneyapp.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<Account> create(@RequestBody Account account){
        try {
            return new ResponseEntity<>(accountService.create(account), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/accounts")
    public ResponseEntity<Iterable<Account>> findAllAccounts(){
        try {
            return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/accounts/user/{userId}")
    public ResponseEntity<Iterable<Account>> findByUserId(@PathVariable Long userId){
        try {
            return new ResponseEntity<>(accountService.findAllAccountsByUserId(userId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(accountService.show(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateBalance(@PathVariable Long id, @RequestBody Account account){
       try {
           return new ResponseEntity<>(accountService.updateBalance(id, account), HttpStatus.OK);
       } catch (Exception e){
           return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
       }
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable Long id){
        try {
            return new ResponseEntity<>(accountService.deleteAccount(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



}
