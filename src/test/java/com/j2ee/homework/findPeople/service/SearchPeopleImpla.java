package com.j2ee.homework.findPeople.service;

import com.j2ee.homework.findPeople.pojo.Person;
import org.junit.Test;
import com.j2ee.homework.findPeople.service.impl.SearchPeopleImpl;

import java.util.List;

public class SearchPeopleImpla {
    @Test
    public void search(){
        SearchPeopleImpl searchPeople = new SearchPeopleImpl();
        List<Person> personList = searchPeople.searchPeople("sun");
        for(Person person:personList){
            long ID = person.getId();
            System.out.println(ID);
        }
    }
}
