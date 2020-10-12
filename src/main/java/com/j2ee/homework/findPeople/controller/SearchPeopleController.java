package com.j2ee.homework.findPeople.controller;


import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.ResponseServer;
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
    public ResponseBody<List<Person>> search(@RequestParam String keyword){
        SearchPeople searchPeopleService = new SearchPeopleImpl();
        ResponseServer<List<Person>> responseServer = searchPeopleService.searchPeople(keyword);
        boolean isSuccessful = responseServer.isSuccessful;
        String message = responseServer.message;
        List<Person> data = responseServer.data;
        return new ResponseBody<>(isSuccessful,message,data);
    }
}
