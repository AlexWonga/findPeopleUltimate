package com.j2ee.homework.findPeople.controller;

import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.impl.SearchPeopleImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.j2ee.homework.findPeople.pojo.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class FindPeopleByPictureController {
    @RequestMapping(value = "/findPeopleByPicture", method = RequestMethod.POST)
    public ResponseBody<List<Person>> findPeopleByPicture(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        if(session.isNew()){
            return new ResponseBody<>(400,"invalidUser",null);
        } else {
            SearchPeopleImpl searchPeopleService = new SearchPeopleImpl();
            List<Person> list = searchPeopleService.searchPeopleByPicture(file);
            return new ResponseBody<>(200,"searchSuccess",list);
        }
    }
}
