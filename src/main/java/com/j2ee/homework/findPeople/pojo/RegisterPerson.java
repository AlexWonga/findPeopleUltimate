package com.j2ee.homework.findPeople.pojo;

import lombok.Data;

@Data
public class RegisterPerson {
    private String name;//姓名
    private String password;//密码
    private String tel;//电话号
    private String QQ;//QQ号
    private String email;//email
}
