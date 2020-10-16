package com.j2ee.homework.findPeople.service.impl;

import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.service.SearchPeople;
import com.j2ee.homework.findPeople.dao.impl.PersonDaoImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.j2ee.homework.findPeople.utils.FaceMatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service("searchPeople")
public class SearchPeopleImpl implements SearchPeople {

//    private static PersonDaoImpl personDao;
//
//    @Autowired
//    public void setPersonDaoImpl(PersonDaoImpl personDaoImpl){
//        personDao = personDaoImpl;
//    }

    @Override
    public List<Person> searchPeople(String keyword,int offset,int limit) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        if (keyword.equals("")) {
            return null;
        } else {
            return personDao.getPersonListPaging(keyword,offset,limit);
        }
    }

    @Override
    public Person login(String username, String password) {
        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = personDao.getPersonByName(username);
        if (person.getPassword().equals(password)) {
            return person;
        } else {
            return null;
        }
    }

    @Override
    public boolean uploadFile(MultipartFile file, int userID) throws IOException {
        PersonDaoImpl personDao = new PersonDaoImpl();
        byte[] bytes = file.getBytes();
        Path path = Paths.get("E://findPeopleUltimate/src/main/resources/static", file.getOriginalFilename());
        Files.write(path, bytes);
        return personDao.uploadPicture(path.toString(),userID);
    }

    @Override
    public List<Person> searchPeopleByPicture(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return null;
        } else {
            PersonDaoImpl personDao = new PersonDaoImpl();
            List<Person> resultList = new ArrayList<>();
            List<Person> personList = personDao.getPersonList();
            byte[] bytes = file.getBytes();
            Path path = Paths.get("E://findPeopleUltimate/src/main/resources/templates", file.getOriginalFilename());
            Files.write(path, bytes);
            String path1 = path.toString();
            for(Person person:personList){
                String path2 = person.getPicturepath();
                if(Objects.isNull(path2)){
                    continue;
                }
                File PictureFile = new File(path2);
                if (!PictureFile.exists()) {
                    continue;
                } else{
                    int score = FaceMatch.faceMatch(path1,path2);
                    if(score>80){
                        resultList.add(person);
                    }
                }
            }
            return resultList;
        }
    }
}
