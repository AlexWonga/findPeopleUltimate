package com.j2ee.homework.findPeople.dao.impl;
import com.j2ee.homework.findPeople.dao.personDao;
import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import com.j2ee.homework.findPeople.mapper.PersonMapper;
import com.j2ee.homework.findPeople.pojo.PersonExample;

//import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author wong
 */


public class PersonDaoImpl implements personDao {

    @Override
    public List<Person> getPersonList() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria = personExample.createCriteria();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        try {
            return mapper.selectByExample(personExample);
        }catch (Exception e){

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person getPersonByName(String username) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria = personExample.createCriteria();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        criteria.andNameEqualTo(username);
        List<Person> personList = mapper.selectByExample(personExample);
        if(!personList.isEmpty()){
            return personList.get(0);
        } else {
            return null;
        }






    }








}
