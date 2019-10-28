package com.edu.dao;

import com.edu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface IUserDao {
    /**
     * 查询用户是否存在
     */
    public Integer isExistUser(@Param("username") String username);
    /**
     * 通过用户名密码查询
     */
    public User findUserAndPwd( @Param("username")String username, @Param("password")String password);
    /**
     * 添加用户
     */
        public  int addUser(User user);
    /**
     * 修改
     */
    public  int updateUser(User user);

}
