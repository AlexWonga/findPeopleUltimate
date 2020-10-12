package com.j2ee.homework.findPeople.utils;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * @author wong
 */
public class HibernateUtil {
    private static Configuration config;
    private static SessionFactory sessionFactory;
    private static ThreadLocal<Session> localSession = new ThreadLocal<>();

    public HibernateUtil() {
    }

    static {
        try {
            config = new Configuration().configure();
            sessionFactory = config.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        Session session = localSession.get();
        // 验证session对象是否为空
        if (session == null) {
            // 使用工厂对象生产session对象
            session = sessionFactory.openSession();
            // 将session对象放入线程
            localSession.set(session);
        }
        return session;
    }

    public static void closeSession() {
        //获取当前线程中的session对象
        Session session = localSession.get();
        // 清空线程中的session对象
        localSession.set(null);
        if (session != null) {
            session.close();
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Configuration getConfig() {
        return config;
    }
}
