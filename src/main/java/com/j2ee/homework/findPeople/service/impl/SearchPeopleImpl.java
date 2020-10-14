package com.j2ee.homework.findPeople.service.impl;

import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.SearchPeople;
import com.j2ee.homework.findPeople.dao.impl.PersonDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service("searchPeople")
public class SearchPeopleImpl implements SearchPeople {

//    private static PersonDaoImpl personDao;
//
//    @Autowired
//    public void setPersonDaoImpl(PersonDaoImpl personDaoImpl){
//        personDao = personDaoImpl;
//    }

    @Override
    public List<Person> searchPeople(String keyword) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        if (keyword.equals("")) {
            return null;
        } else {
            List<Person> personList = personDao.getPersonList();
            List<Person> resultData = new ArrayList<>();
            for (Person person : personList) {
                long ID = person.getId();
                String name = person.getName();
                String tel = person.getTelephone();
                String QQ = person.getQq();
                String email = person.getEmail();
                if (Long.toString(ID).contains(keyword) || name.contains(keyword) || tel.contains(keyword) || QQ.contains(keyword) || email.contains(keyword)) {
                    resultData.add(person);
                }
            }
            return resultData;

        }
    }

    @Override
    public Person login(String username, String password) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = personDao.getPersonByName(username);
        if (person.getPassword().equals(password)) {
            return person;
        } else {
            return null;
        }
    }
}
