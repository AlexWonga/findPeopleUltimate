package com.j2ee.homework.findPeople.controller;


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

/**
 * @author wong
 */
@RestController
public class SearchPeopleController {
    @Autowired
    SearchPeople searchPeopleService;
    @RequestMapping(value = "/searchPeople",method = RequestMethod.GET)
    public ResponseBody<List<Person>> search(@RequestParam String keyword){
        List<Person> list = searchPeopleService.searchPeople(keyword);
        return new ResponseBody<>(200,"searchSuccess",list);
    }
}
