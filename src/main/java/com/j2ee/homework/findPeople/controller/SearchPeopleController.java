package com.j2ee.homework.findPeople.controller;


import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.SearchPeople;
import com.j2ee.homework.findPeople.service.impl.SearchPeopleImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wong
 */
@RestController
public class SearchPeopleController {
    @RequestMapping(value = "/searchPeople",method = RequestMethod.GET)
    public List<Person> search(@RequestParam String keyword){
        SearchPeople searchPeopleService = new SearchPeopleImpl();
        return searchPeopleService.searchPeople(keyword);
    }
}
