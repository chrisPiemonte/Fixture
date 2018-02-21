package com.database.systems.fixture.common.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by chris on 2/20/18.
 */
public class zprova {

    public static void main(String[] args) {
        // System.out.println(System.getProperty("user.dir"));
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        try {
            // persist(sessionFactory);
            load(sessionFactory);
        } finally {
            sessionFactory.close();
        }
    }

    private static void load(SessionFactory sessionFactory) {
        System.out.println("-- loading stagioni --");
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Stagione> stagioni = (List<Stagione>) session.createQuery("FROM Stagione").list();
        stagioni.forEach((x) -> System.out.println("\n\n\n--------- " + x));
        session.close();
    }

    private static void persist(SessionFactory sessionFactory) {
        Stagione p1 = new Stagione("2122");
        Stagione p2 = new Stagione("3132");
        System.out.println("-- persisting persons --");
        System.out.printf("- %s%n- %s%n", p1, p2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p1);
        session.save(p2);
        session.getTransaction().commit();
    }


}
