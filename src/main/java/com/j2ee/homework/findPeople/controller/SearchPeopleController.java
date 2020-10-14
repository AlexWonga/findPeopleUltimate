package com.j2ee.homework.findPeople.controller;


import com.j2ee.homework.findPeople.dao.impl.PersonDaoImpl;
import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.pojo.ResponseBody;
import com.j2ee.homework.findPeople.service.SearchPeople;
import com.j2ee.homework.findPeople.service.impl.SearchPeopleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author wong
 */
@RestController
public class SearchPeopleController {
//    @Autowired
//    SearchPeople searchPeopleService;
    @RequestMapping(value = "/searchPeople",method = RequestMethod.GET)
    public ResponseBody<List<Person>> search(@RequestParam String keyword) {
        System.out.println(keyword);
        SearchPeople searchPeopleService = new SearchPeopleImpl();
        List<Person> list = searchPeopleService.searchPeople(keyword);
        if(Objects.isNull(list)) {
            return new ResponseBody<>(200, "searchSuccess", null);
        } else {
            return new ResponseBody<>(200, "searchSuccess", list);
        }
    }
}
