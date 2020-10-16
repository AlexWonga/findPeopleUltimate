package com.j2ee.homework.findPeople.service;

import com.j2ee.homework.findPeople.pojo.Person;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author wong
 */
public interface SearchPeople {
    List<Person> searchPeople(String keyword);
    Person login(String username,String password);
    boolean uploadFile(MultipartFile file,int userID) throws IOException;
}
