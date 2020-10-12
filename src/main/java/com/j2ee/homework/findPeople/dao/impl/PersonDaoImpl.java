package com.j2ee.homework.findPeople.dao.impl;
import com.j2ee.homework.findPeople.dao.personDao;
import com.j2ee.homework.findPeople.pojo.Person;
import com.j2ee.homework.findPeople.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author wong
 */
public class PersonDaoImpl implements personDao {

    @Override
    public List<Person> getPersonList() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query<Person> query = session.createQuery("from Person");
            List<Person> list = query.list();
            for(Person person: list){
                System.out.println(person.getName());
            }
            transaction.commit();
            return list;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            HibernateUtil.closeSession();
        }
        return null;
    }
}
