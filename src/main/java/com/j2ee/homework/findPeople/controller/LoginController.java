package com.j2ee.homework.findPeople.controller;

import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.SearchPeople;
import com.j2ee.homework.findPeople.service.impl.SearchPeopleImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.j2ee.homework.findPeople.pojo.ResponseBody;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
public class LoginController {
//    @Autowired
//    @Qualifier("searchPeople")
//    private SearchPeople searchPeopleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseBody<Person> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        SearchPeople searchPeopleService = new SearchPeopleImpl();
        System.out.println(username + " " + password);
        Person person = searchPeopleService.login(username, password);
        if (Objects.isNull(person)) {
            return new ResponseBody<>(200, "invalidPerson", null);
        } else {
            HttpSession session = request.getSession();
            System.out.println(person.getId());
            session.setAttribute("userID", person.getId());
            int userID = (int) session.getAttribute("userID");
            System.out.println(userID);
            session.setMaxInactiveInterval(6000);
            return new ResponseBody<>(200, "loginSuccess", person);
        }
    }
}
