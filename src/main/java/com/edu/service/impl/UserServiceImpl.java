package com.edu.service.impl;

import com.edu.dao.IUserDao;
import com.edu.exception.MyException;
import com.edu.pojo.User;
import com.edu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private  IUserDao dao;
    @Override
    public User login(String username, String password) throws MyException {
            if(username=="" || username==null){
                    throw new MyException(1, "用户名不能为空");
            }if(password=="" || password==null){
                    throw new MyException(2, "密码不能为空");
        }

        int  flag = dao.isExistUser(username);
        if(flag==1){
            User user = dao.findUserAndPwd(username, password);
            return  user;
        }else{
            String msg="用户名不存在 ，请重新登录";
            throw new MyException(0,msg);
        }
    }
    /**
     * 定时任务
     */
    @Scheduled(cron = "0/1 * * * * ?")
    @Override
    public void myScheduler() {
        System.out.println("==============");


    }

}

