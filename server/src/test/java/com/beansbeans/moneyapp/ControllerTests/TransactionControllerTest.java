//package com.beansbeans.moneyapp.ControllerTests;
//
//import com.beansbeans.moneyapp.Controllers.TransactionController;
//import com.beansbeans.moneyapp.Model.Transaction;
//import com.beansbeans.moneyapp.Services.TransactionService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TransactionControllerTest {
//
//    Transaction testTransaction = new Transaction(4L,5L,6L,300.0,"this is a memo", LocalDateTime.now(), 1L);
//    Transaction testTransaction2 = new Transaction(5L,6L,7L,100.0,"this is also a memo", LocalDateTime.now(), 2L);
//
//    @Mock
//    private TransactionService transactionService;
//
//    @InjectMocks
//    private TransactionController transactionController;
//
//
//    @Test
//    public void createTransactionTest(){
//        Transaction transaction = mockTransaction();
//
//        when(transactionService.newTransaction(transaction)).thenReturn(transaction);
//        transactionController.createTransaction(transaction);
//
//        verify(transactionService, times(1)).newTransaction(transaction);
//    }
//
//    @Test
//    public void findByIdTest(){
//        when(transactionService.findTransactionById(1L)).thenReturn(testList().get(1));
//        transactionController.findById(1L);
//
//        verify(transactionService, times(1)).findTransactionById(1L);
//    }
//
//    @Test
//    public void findByUserIdTest(){
//        when(transactionService.findTransactionByUserId(9L)).thenReturn(testList().get(1));
//        transactionController.findByUserId(9L);
//
//        verify(transactionService, times(1)).findTransactionByUserId(9L);
//    }
//
//    @Test
//    public void getAllTransactionsTest(){
//        when(transactionService.getAllTransactions()).thenReturn(testList());
//        transactionController.getAllTransactions();
//
//        verify(transactionService, times(1)).getAllTransactions();
//    }
//
//    @Test
//    public void depositTest(){
//        when(transactionService.depositTo(6L, 300.0)).thenReturn(true);
//        transactionController.deposit(testTransaction);
//
//        verify(transactionService, times(1 )).depositTo(6L,300.0);
//    }
//
//    @Test
//    public void withdrawTest(){
//        when(transactionService.withdrawFrom(5L, 300.0)).thenReturn(true);
//        transactionController.withdraw(testTransaction);
//
//        verify(transactionService, times(1)).withdrawFrom(5L, 300.0);
//    }
//
//    @Test
//    public void transferTest(){
//        when(transactionService.transferFunds(6L,7L, 100.00)).thenReturn(true);
//        transactionController.transfer(testTransaction2);
//
//        verify(transactionService, times(1)).transferFunds(6L,7L,100.0);
//    }
//
//    private Transaction mockTransaction(){
//        return new Transaction(1L, 2L,3L,100.0, "this is a memo", LocalDateTime.now(), 7L);
//    }
//
//    private List<Transaction> testList(){
//        Transaction transaction1 = new Transaction(2L,3L,4L,200.0, "this is a memo", LocalDateTime.now(), 8L);
//        Transaction transaction2 = new Transaction(3L,4L,5L,400.0, "this is a memo", LocalDateTime.now(),9L);
//
//        return Arrays.asList(transaction1, transaction2);
//    }
//}
//
