package com.j2ee.homework.findPeople.service;

import com.j2ee.homework.findPeople.pojo.Person;

import java.util.List;

/**
 * @author wong
 */
public interface SearchPeople {
    ResponseServer<List<Person>> searchPeople(String keyword);
}
