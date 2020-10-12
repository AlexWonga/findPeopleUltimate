package com.j2ee.homework.findPeople.dao;
import com.j2ee.homework.findPeople.pojo.Person;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
public class hibernateTest {
    @Test
    public void testInsert(){
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = new Person();
        person.setName("sun");
        person.setEmail("135@126.com");
        person.setPassword("123");
        person.setQQ("421");
        person.setTel("1234556");
        session.save(person);
        transaction.commit();
        sessionFactory.close();
    }
}
