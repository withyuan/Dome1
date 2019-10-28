package com.edu.test;

import com.edu.exception.MyException;
import com.edu.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestTx {
    @Autowired
    AccountService accountService;
    @Test
    public void transfer() throws MyException {
        accountService.transfer( "aaa","bbb",200.0);
    }
}
