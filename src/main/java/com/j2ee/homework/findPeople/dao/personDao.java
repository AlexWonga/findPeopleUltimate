package com.j2ee.homework.findPeople.dao;

import com.j2ee.homework.findPeople.pojo.Person;

import java.util.List;

public interface personDao {
    List<Person> getPersonList();
    Person getPersonByName(String username);
//    List<Person> searchPeople(String keyword);
    boolean uploadPicture(String picturePath, int userID);
    List<Person> getPersonListPaging(String keyword,int offset,int limit);
    Person getPersonByID(int userID);
    boolean addPerson(Person person);
    boolean deletePerson(int userID);
    boolean modifyPerson(Person person);
}
