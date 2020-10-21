package com.j2ee.homework.findPeople.service.impl;

import com.j2ee.homework.findPeople.dao.impl.PersonDaoImpl;
import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.AdminService;

import java.util.List;
import java.util.Objects;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean addPerson(String username, String password, String telephone, String email, String QQ, int sessionUserID) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person admin = personDao.getPersonByID(sessionUserID);
        if (Objects.isNull(admin) || !(admin.getUsertype().equals("ADMIN"))) {
            return false;
        } else {
            Person person = new Person(username,password,telephone,email,QQ,"NORMAL");
            return personDao.addPerson(person);

        }
    }

    @Override
    public boolean deletePerson(int userID, int sessionUserID) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person admin = personDao.getPersonByID(sessionUserID);
        if (Objects.isNull(admin) || !(admin.getUsertype().equals("ADMIN"))) {
            return false;
        } else {
            return personDao.deletePerson(userID);
        }
    }

    @Override
    public boolean modifyPerson(int userID, String username, String password, String telephone, String email, String QQ, int sessionUserID) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person admin = personDao.getPersonByID(sessionUserID);
        if (Objects.isNull(admin) || !(admin.getUsertype().equals("ADMIN"))) {
            return false;
        } else {
            Person person = new Person(userID,username,password,telephone,email,QQ,"NORMAL");
            return personDao.modifyPerson(person);
        }
    }

    @Override
    public List<Person> selectAllUser(int sessionUserID) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        return personDao.getPersonList();
    }
}
