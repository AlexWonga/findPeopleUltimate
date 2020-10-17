package com.j2ee.homework.findPeople.dao.impl;

import com.j2ee.homework.findPeople.dao.personDao;
import com.j2ee.homework.findPeople.mapper.PersonMapper;
import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.pojo.PersonExample;
import com.j2ee.homework.findPeople.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;


import java.io.File;
import java.util.List;

/**
 * @author wong
 */


public class PersonDaoImpl implements personDao {

    @Override
    public List<Person> getPersonList() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonExample personExample = new PersonExample();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        try {
            return mapper.selectByExample(personExample);
        } catch (Exception e) {
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
        if (!personList.isEmpty()) {
            sqlSession.close();
            return personList.get(0);
        } else {
            return null;
        }


    }

    @Override
    public boolean uploadPicture(String picturePath, int userID) {
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            PersonExample personExample = new PersonExample();
            PersonExample.Criteria criteria = personExample.createCriteria();
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            criteria.andIdEqualTo(userID);
            List<Person> personList = mapper.selectByExample(personExample);
            if (!personList.isEmpty()) {
                Person person = personList.get(0);
                if(!person.getPicturepath().equals(picturePath)) {
                    File file = new File(person.getPicturepath());
                    boolean flag = file.delete();
                    if(!flag){
                        return false;
                    }
                    person.setPicturepath(picturePath);
                    mapper.updateByExample(person, personExample);
                }
                sqlSession.commit();
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Person> getPersonListPaging(String keyword,int offset, int limit) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria1 = personExample.createCriteria();
        PersonExample.Criteria criteria2 = personExample.createCriteria();
        PersonExample.Criteria criteria3 = personExample.createCriteria();
        PersonExample.Criteria criteria4 = personExample.createCriteria();
        criteria1.andNameLike("%"+keyword+"%");
        criteria2.andTelephoneLike("%"+keyword+"%");
        criteria3.andQqLike("%"+keyword+"%");
        criteria4.andEmailLike("%"+keyword+"%");
        personExample.or(criteria2);
        personExample.or(criteria3);
        personExample.or(criteria4);
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        try {
            RowBounds rowBounds = new RowBounds(offset, limit);

            List<Person> list = mapper.selectByExampleWithRowbounds(personExample,rowBounds);

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
