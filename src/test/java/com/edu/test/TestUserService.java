package com.edu.test;

import com.edu.dao.IUserDao;
import com.edu.exception.MyException;
import com.edu.pojo.User;
import com.edu.service.IUserService;
import com.edu.service.impl.UserServiceImpl;
import com.edu.utils.MD5Utils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

    @Test
    public  void testUserService() throws MyException {

        IUserService userService = new UserServiceImpl();
        userService.login("zhangsan", "123");

    }
    @Test
    public void testMyBaits(){
//        IUserDao dao = new MyBatsUserImpl();
//        int a=dao.isExistUser("root");
//       System.out.println(a);
    }
    @Test
    public void testAddUser(){
//        IUserDao dao = new MyBatsUserImpl();
        User user=new User();
        user.setAnswer("xx");
        user.setEmail("xx@qq.crr");
        user.setIp("xxxxx.xxxx.xx");
        user.setPassword(MD5Utils.getMD5Code("12345"));
        user.setUsername("xxx");
        user.setQuestion("xx");
        user.setPhone("122");
        user.setRole(0);
//        dao.addUser(user);



 }
 @Test
    public void testSpring() throws MyException {
     ApplicationContext as=new ClassPathXmlApplicationContext("classpath:spring.xml");
     IUserDao userDao = as.getBean(IUserDao.class);
     User a = userDao.findUserAndPwd("root", "root");
     System.out.println(a);
     User user = as.getBean(User.class);
     user.setId(24);
     user.setAnswer("xaa改过的x");
     user.setEmail("xaax@qq.crr");
     user.setIp("xxxaaxx.xxaaxx.xx");
     user.setPassword(MD5Utils.getMD5Code("xaa改过的x"));
     user.setUsername("xxax");
     user.setQuestion("xxs");
     user.setPhone("12s2");
     user.setRole(1);
     userDao.updateUser(user);

 }
}
