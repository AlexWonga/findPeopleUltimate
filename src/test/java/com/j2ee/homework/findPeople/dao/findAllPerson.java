package com.j2ee.homework.findPeople.dao;

import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class findAllPerson {
    @Test
    public void find() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query<Person> query = session.createQuery("from Person");
            List<Person> list = query.list();
            for (Person person : list) {
                System.out.println(person.getName());
            }
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }

    }
}

