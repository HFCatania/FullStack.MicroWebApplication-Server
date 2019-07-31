package com.beansbeans.moneyapp.Controllers;

import com.beansbeans.moneyapp.Model.Transaction;
import com.beansbeans.moneyapp.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@CrossOrigin
@RequestMapping(path="/api")
@Transactional
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        try {
            return new ResponseEntity<>(transactionService.newTransaction(transaction), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(transactionService.findTransactionById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/transaction/{userId}")
    public ResponseEntity<Transaction> findByUserId(@PathVariable Long userId){
        try {
            return new ResponseEntity<>(transactionService.findTransactionByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/transaction")
    public ResponseEntity<Iterable<Transaction>> getAllTransactions(){
        try {
            return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/transaction/deposit")
    public ResponseEntity<Boolean> deposit(@RequestBody Transaction transaction){
       try {
           Double amount = transaction.getAmount();
           Long toAccountId = transaction.getToAccountId();
           return new ResponseEntity<>(transactionService.depositTo(toAccountId, amount), HttpStatus.OK);
       } catch (Exception e){
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }
    }

    @PostMapping("/transaction/withdraw/{fromAccountId}")
    public ResponseEntity<Boolean> withdraw(@RequestBody Transaction transaction){
        try {
            Double amount = transaction.getAmount();
            Long fromAccountId = transaction.getFromAccountId();
            return new ResponseEntity<>(transactionService.withdrawFrom(fromAccountId, amount), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/transaction/transfer")
    public ResponseEntity<Boolean> transfer(@RequestBody Transaction transaction){
       try {
           Long fromAccountId = transaction.getFromAccountId();
           Long toAccountId = transaction.getToAccountId();
           Double amount = transaction.getAmount();
           return new ResponseEntity<>(transactionService.transferFunds(fromAccountId, toAccountId, amount), HttpStatus.OK);
       } catch (Exception e){
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }
    }
}
