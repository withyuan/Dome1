package com.edu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.io.Serializable;
/**
 * 用户实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User  implements Serializable{
    private  int id;
    private String username;
    private  String password;
    private String email;
    private String phone;
    private  String question;
    private String answer;
    private  int role;
    private Date create_time;
    private Date update_time;
    private  String ip;
public User(int id,String username,String password){
    this.id=id;
    this.username=username;
    this.password=password;

}

}
