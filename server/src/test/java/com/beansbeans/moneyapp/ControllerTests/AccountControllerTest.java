package com.beansbeans.moneyapp.ControllerTests;

import com.beansbeans.moneyapp.Controllers.AccountController;
import com.beansbeans.moneyapp.Model.Account;
import com.beansbeans.moneyapp.Services.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;


    @Test
    public void createAccount(){
        Account account = new Account();

        when(accountService.create(account)).thenReturn(account);
        accountController.create(account);

        verify(accountService, times(1)).create(account);
    }

    @Test
    public void findAllAccounts(){
        Account account = new Account();

        when(accountService.getAllAccounts()).thenReturn(testList());
        accountController.findAllAccounts();

        verify(accountService, times(1)).getAllAccounts();
    }

    @Test
    public void findByUserId(){
        Long id = 1l;

        when(accountService.findAllAccountsByUserId(id)).thenReturn(testList());
        accountController.findByUserId(id);

        verify(accountService, times(1)).findAllAccountsByUserId(id);
    }

    @Test
    public void getById(){
        Long id = 1l;
        Account acc = new Account();

        when(accountService.show(id)).thenReturn(acc);
        accountController.getById(id);

        verify(accountService, times(1)).show(id);
    }

    @Test
    public void updateBalance(){
        Long id = 1l;
        Account acc = new Account();

        when(accountService.updateBalance(id, acc)).thenReturn(acc);
        accountController.updateBalance(id, acc);

        verify(accountService, times(1)).updateBalance(id, acc);
    }

    @Test
    public void deleteAccount(){
        Long id = 1l;
        Account acc = new Account();

        when(accountService.deleteAccount(id)).thenReturn(true);
        accountController.deleteAccount(id);

        verify(accountService, times(1)).deleteAccount(id);
    }

    private List<Account> testList(){
        Account one = new Account();
        Account two = new Account();
        return Arrays.asList(one, two);
    }
}
