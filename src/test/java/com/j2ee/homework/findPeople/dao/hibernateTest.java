package com.j2ee.homework.findPeople.dao;
import com.j2ee.homework.findPeople.dao.impl.PersonDaoImpl;
import com.j2ee.homework.findPeople.pojo.Person;
import org.junit.Test;

import java.util.List;

public class hibernateTest {
    @Test
    public void testInsert(){
//        Configuration config = new Configuration().configure();
//        SessionFactory sessionFactory = config.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Person person = new Person();
//        person.setName("wong");
//        person.setEmail("135@126.com");
//        person.setPassword("123");
//        person.setQQ("421");
//        person.setTelephone("1234556");
//        session.save(person);
//        transaction.commit();
//        sessionFactory.close();
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            Query<Person> query = session.createQuery("from Person");
//            List<Person> list = query.list();
//            for(Person o :list){
//                System.out.println(o instanceof Person);
//            }
//            transaction.commit();
//        }catch (Exception e){
//            transaction.rollback();
//            e.printStackTrace();
//        }finally {
//            HibernateUtil.closeSession();
//        }
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
//        PersonExample example = new PersonExample();
//        PersonExample.Criteria criteria = example.createCriteria();
//        criteria.andNameEqualTo("sun");
//        List<Person> list = mapper.selectByExample(example);
//        for(Person person:list){
//            System.out.println(person.getName());
//        }
        PersonDaoImpl personDao = new PersonDaoImpl();
        List<Person> list = personDao.getPersonList();
        for(Person person:list){
            System.out.println(person.getName());
        }
    }
}
