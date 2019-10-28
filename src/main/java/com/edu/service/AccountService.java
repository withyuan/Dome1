package com.edu.service;

import com.edu.dao.AccountDao;
import com.edu.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    IUserService userService;

    @Autowired
    AccountDao accountDao;

    @Transactional(
            isolation= Isolation.REPEATABLE_READ
            ,timeout =1,
            readOnly = false,
            rollbackFor = {NullPointerException.class,RuntimeException.class},
            noRollbackFor = {IndexOutOfBoundsException.class},propagation= Propagation.MANDATORY)
    public void  transfer(String out,String in,Double money) throws MyException {

        accountDao.outMoney(out,money);

        int i=1/0;
        accountDao.inMoney(in,money);


        userService.login("admin","admin");


    }

}
