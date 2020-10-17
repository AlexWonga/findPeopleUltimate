package com.j2ee.homework.findPeople.dao;

import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.SearchPeople;
import com.j2ee.homework.findPeople.service.impl.SearchPeopleImpl;
import org.junit.Test;

import java.util.List;

public class getPersonByName {
    @Test
    public void test(){
        SearchPeople searchPeople = new SearchPeopleImpl();
        List<Person> personList = searchPeople.searchPeople("su",0,6);
        for(Person person:personList){
            System.out.println(person.getName());
        }
    }
}
