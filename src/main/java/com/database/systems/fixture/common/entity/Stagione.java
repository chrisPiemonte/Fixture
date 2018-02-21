package com.database.systems.fixture.common.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by chris on 2/20/18.
 */

@Entity
@Table(name = "Stagione")
public class Stagione implements Serializable {


    @Id
    @Column(name = "anno")
    private String anno;

    public Stagione() {
    }

    public Stagione(String anno) {
        this.anno = anno;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "Stagione{" +
                "anno=" + anno +
                '}';
    }



/*

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {

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

*/

}
