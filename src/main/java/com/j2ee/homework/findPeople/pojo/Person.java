package com.j2ee.homework.findPeople.pojo;
import javax.persistence.*;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

//学号或者教工号（唯一），姓名（允许重名），电话号码（唯一），QQ（可以没有），
// 邮箱（可以没有）。
@Entity
@Table(name="person")
@Data
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long ID;//学号或教工号

    private String name;//姓名
    private String password;//密码
    private String tel;//电话号
    private String QQ;//QQ号
    private String email;//email


}
