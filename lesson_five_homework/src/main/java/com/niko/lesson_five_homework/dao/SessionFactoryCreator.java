package com.niko.lesson_five_homework.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryCreator {

    private static volatile SessionFactory uniqueInstance;

    private SessionFactoryCreator() {
    }

    public static SessionFactory getSessionFactory() {
        if (uniqueInstance == null) {
            synchronized (SessionFactoryCreator.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .buildSessionFactory();
                }
            }
        }

        return uniqueInstance;
    }
}
