package com.j2ee.homework.findPeople.controller;

import com.j2ee.homework.findPeople.service.impl.SearchPeopleImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import com.j2ee.homework.findPeople.pojo.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController

public class UploadPictureController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResponseBody<Void> uploadPicture(@RequestParam MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return new ResponseBody<>(400, "uploadFalse", null);
        }
        try {
            HttpSession session = request.getSession();
            if(session.isNew()) {
                return new ResponseBody<>(400,"invalidUser",null);
            }
            int userID = (int) session.getAttribute("userID");
            SearchPeopleImpl searchPeopleService = new SearchPeopleImpl();
            boolean flag = searchPeopleService.uploadFile(file,userID);
            if(flag)
            return new ResponseBody<>(200, "uploadSuccess", null);
            else {
                return new ResponseBody<>(500,"uploadFailed",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
