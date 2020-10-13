package com.j2ee.homework.findPeople.controller;
import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.SearchPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.j2ee.homework.findPeople.pojo.ResponseBody;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class LoginController {
    @Autowired
    SearchPeople searchPeopleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseBody<Person> login(@RequestParam String username, @RequestParam String password) {
        Person person = searchPeopleService.login(username, password);
        if(Objects.isNull(person)){
            return new ResponseBody<Person>(200,"invalidPerson",null);
        } else{
            return new ResponseBody<Person>(200,"searchPeopleSuccess",person);
        }
    }
}
