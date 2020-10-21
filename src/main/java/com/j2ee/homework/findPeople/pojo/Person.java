package com.j2ee.homework.findPeople.pojo;


public class Person {
    private Integer id;

    private String name;

    private String password;

    private String telephone;

    private String email;

    private String qq;

    private String picturepath;

    private String usertype;

    public Person(Integer id, String name, String password, String telephone, String email, String qq, String usertype) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.qq = qq;
        this.usertype = usertype;
    }

    public Person(String name, String password, String telephone, String email, String qq, String usertype) {
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.qq = qq;
        this.usertype = usertype;
    }

    public Person(Integer id, String name, String password, String telephone, String email, String qq, String picturepath, String usertype) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.qq = qq;
        this.picturepath = picturepath;
        this.usertype = usertype;
    }

    public Person() {
    }

    public Person(Integer id, String name, String password, String telephone, String email, String qq) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.qq = qq;
        this.picturepath = null;
        this.usertype = null;
    }

    public Person(String name, String password, String telephone, String email, String qq) {
        this.id = null;
        this.picturepath = null;
        this.usertype = null;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.qq = qq;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath == null ? null : picturepath.trim();
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }
}