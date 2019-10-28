package com.edu.service;

import com.edu.exception.MyException;
import com.edu.pojo.User;

public interface IUserService {
    public User login(String name,String password) throws MyException;

public void myScheduler();
}
