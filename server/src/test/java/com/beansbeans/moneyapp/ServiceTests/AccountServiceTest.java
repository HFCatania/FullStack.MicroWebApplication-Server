package com.beansbeans.moneyapp.ServiceTests;

import com.beansbeans.moneyapp.Model.Account;
import com.beansbeans.moneyapp.Repositories.AccountRepository;
import com.beansbeans.moneyapp.Services.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTest {
//
//    @Mock
//    private AccountRepository mockRepository;
//
//    @InjectMocks
//    private AccountService accountService;
//
//    @Before
//    public void setup(){
//        mockRepository = mock(AccountRepository.class);
//        accountService = new AccountService(mockRepository);
//    }
//
//    @Test
//    public void createAccountTest(){
//        Long id = 5L;
//        Double balance = 100.0;
//        Long userId = 2L;
//        Account account = new Account(id, balance, userId);
//        Account expected = new Account(id, balance, userId);
//
//        when(mockRepository.findById(5L)).thenReturn(java.util.Optional.of(expected));
//
//        Account actual = null;
//        actual = accountService.create(account);
//        Assert.assertEquals(expected, actual);
//
    }
//
////    @Test
////    public void find
//}
