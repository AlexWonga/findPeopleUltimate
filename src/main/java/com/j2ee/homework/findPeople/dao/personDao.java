package com.j2ee.homework.findPeople.dao;
import com.j2ee.homework.findPeople.pojo.Person;
import java.util.List;

public interface personDao {
    List<Person> getPersonList();
}
