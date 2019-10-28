/*
package com.edu.dao.impl;

import com.edu.dao.IUserDao;
import com.edu.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
@Repository
public class MyBatsUserImpl  implements IUserDao {
    @Autowired
    private    SqlSession session;

    @Override
    public Integer  isExistUser(String username) {
        int  index =(Integer) session.selectOne("com.edu.pojo.User.isExistUser", username);

        return index;
    }

    @Override
    public User findUserAndPwd(String username, String password) {
        Map<String,Object> map=new HashMap<>();
        map.put("username",username);
        map.put("password",password);

        User user = (User)session.selectOne("com.edu.pojo.User.findUserAndPwd",map );
        return user;
    }
    @Override
    public int addUser(User user) {
       int a= session.insert("com.edu.pojo.User.addUser",user);
        session.commit();
        session.close();
        return a;
    }
    @Override
    public int updateUser(User user) {
        return 0;
    }
}
*/
