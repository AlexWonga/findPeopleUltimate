package com.j2ee.homework.findPeople.service.impl;

import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.ResponseServer;
import com.j2ee.homework.findPeople.service.SearchPeople;
import com.j2ee.homework.findPeople.dao.impl.PersonDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class SearchPeopleImpl implements SearchPeople {
    @Override
    public ResponseServer<List<Person>> searchPeople(String keyword) {
        if (keyword.equals("")) {
            return new ResponseServer<>(false, "invalidKeyword", null);
        } else {
            PersonDaoImpl personDao = new PersonDaoImpl();
            List<Person> personList = personDao.getPersonList();
            List<Person> resultData = new ArrayList<>();
            for (Person person : personList) {
                long ID = person.getID();
                String name = person.getName();
                String tel = person.getTel();
                String QQ = person.getQQ();
                String email = person.getEmail();
                if (Long.toString(ID).contains(keyword) || name.contains(keyword) || tel.contains(keyword) || QQ.contains(keyword) || email.contains(keyword)) {
                    resultData.add(person);
                }
            }
            return new ResponseServer<>(true, "searchSuccessful", resultData);
        }
    }
}
