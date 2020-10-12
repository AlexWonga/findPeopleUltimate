package com.j2ee.homework.findPeople.pojo;

import lombok.Data;

//学号或者教工号（唯一），姓名（允许重名），电话号码（唯一），QQ（可以没有），
// 邮箱（可以没有）。
@Data
public class Person {
    private int id;
    private String name;
    private String password;
    private String tel;
    private String QQ;
    private String email;
}
