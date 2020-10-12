package com.j2ee.homework.findPeople.dao;
import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.pojo.RegisterPerson;

import java.util.List;

public interface personDao {
    List<Person> getPersonList();
    Person getPersonByName(String username);
}
