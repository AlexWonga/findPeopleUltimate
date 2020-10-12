package com.j2ee.homework.findPeople.controller;
import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.SearchPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    SearchPeople searchPeopleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Person login(@RequestParam String username, @RequestParam String password) {
        return searchPeopleService.login(username, password);
    }
}
