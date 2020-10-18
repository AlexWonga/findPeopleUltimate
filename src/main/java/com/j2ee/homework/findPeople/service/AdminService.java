package com.j2ee.homework.findPeople.service;

import com.j2ee.homework.findPeople.pojo.Person;

import java.util.List;

public interface AdminService {
    boolean addPerson(String username, String password, String telephone, String email, String QQ, int sessionUserID);

    boolean deletePerson(int userID, int sessionUserID);

    boolean modifyPerson(int userID, String username, String password, String telephone, String email, String QQ, int sessionUserID);

    List<Person> selectAllUser(int sessionUserID);
}
