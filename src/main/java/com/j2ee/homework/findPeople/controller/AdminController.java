package com.j2ee.homework.findPeople.controller;


import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.pojo.ResponseBody;
import com.j2ee.homework.findPeople.service.AdminService;
import com.j2ee.homework.findPeople.service.impl.AdminServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
public class AdminController {
    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public ResponseBody<Void> addPerson(@RequestParam String username, @RequestParam String password, @RequestParam String telephone, @RequestParam String QQ, @RequestParam String email, HttpServletRequest request) {
        HttpSession session = request.getSession();
        AdminService adminService = new AdminServiceImpl();
        if (session.isNew()) {
            return new ResponseBody<>(400, "invalidUser", null);
        } else {
            int userID = (int) session.getAttribute("userID");
            boolean flag = adminService.addPerson(username, password, telephone, email, QQ, userID);
            if (flag)
                return new ResponseBody<>(200, "addSuccess", null);
            else
                return new ResponseBody<>(500, "addFailed", null);
        }
    }

    @RequestMapping(value = "/deletePerson", method = RequestMethod.POST)
    public ResponseBody<Void> deletePerson(HttpServletRequest request, @RequestParam int userID) {
        HttpSession session = request.getSession();
        AdminService adminService = new AdminServiceImpl();
        if (session.isNew()) {
            return new ResponseBody<>(400, "invalidUser", null);
        } else {
            int sessionUserID = (int) session.getAttribute("userID");
            boolean flag = adminService.deletePerson(userID, sessionUserID);
            if (flag)
                return new ResponseBody<>(200, "deletePersonSuccess", null);
            else
                return new ResponseBody<>(500, "deletePersonFailed", null);
        }
    }

    @RequestMapping(value = "/modifyPerson", method = RequestMethod.POST)
    public ResponseBody<Void> modifyPerson(@RequestParam int userID, @RequestParam String username, @RequestParam String password, @RequestParam String telephone, @RequestParam String QQ, @RequestParam String email, HttpServletRequest request) {
        HttpSession session = request.getSession();
        AdminService adminService = new AdminServiceImpl();
        if (session.isNew()) {
            return new ResponseBody<>(400, "invalidUser", null);
        } else {
            int sessionUserID = (int) session.getAttribute("userID");
            boolean flag = adminService.modifyPerson(userID, username, password, telephone, email, QQ, sessionUserID);
            if (flag)
                return new ResponseBody<>(200, "modifyPersonSuccess", null);
            else
                return new ResponseBody<>(500, "modifyPersonFailed", null);
        }
    }

    @RequestMapping(value = "/queryAllPerson", method = RequestMethod.POST)
    public ResponseBody<List<Person>> queryAllPerson(HttpServletRequest request) {
        HttpSession session = request.getSession();
        AdminService adminService = new AdminServiceImpl();
        if (session.isNew()) {
            return new ResponseBody<>(400, "invalidUser", null);
        } else {
            int sessionUserID = (int) session.getAttribute("userID");
            List<Person> list = adminService.selectAllUser(sessionUserID);
            return new ResponseBody<>(200, "queryAllUserSuccess", list);
        }
    }
}
