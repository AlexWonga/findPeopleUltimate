package com.j2ee.homework.findPeople.dao;

import com.j2ee.homework.findPeople.dao.impl.PersonDaoImpl;
import com.j2ee.homework.findPeople.pojo.Person;
import org.junit.Test;

import java.util.List;

public class findAllPerson {
    @Test
    public void find() {
        PersonDaoImpl personDao = new PersonDaoImpl();
        List<Person> list = personDao.getPersonList();
        for (Person o : list) {
            long id = o.getId();
            System.out.println(id);
            String name = o.getName();
            System.out.println(name);
        }

    }
}

