package com.j2ee.homework.findPeople.controller;


import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.pojo.ResponseBody;
import com.j2ee.homework.findPeople.service.SearchPeople;
import com.j2ee.homework.findPeople.service.impl.SearchPeopleImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @author wong
 */
@RestController
public class SearchPeopleController {
    //    @Autowired
//    SearchPeople searchPeopleService;
    @RequestMapping(value = "/searchPeople", method = RequestMethod.GET)
    public ResponseBody<List<Person>> search(@RequestParam String keyword, @RequestParam int offset, @RequestParam int limit, HttpServletRequest request) {
        System.out.println(keyword);
        HttpSession session = request.getSession();
        if (session.isNew()) {
            return new ResponseBody<>(400, "invalidUser", null);
        }
        SearchPeople searchPeopleService = new SearchPeopleImpl();
        List<Person> list = searchPeopleService.searchPeople(keyword, offset, limit);
        if (Objects.isNull(list)) {
            return new ResponseBody<>(200, "searchSuccess", null);
        } else {
            return new ResponseBody<>(200, "searchSuccess", list);
        }
    }
}
