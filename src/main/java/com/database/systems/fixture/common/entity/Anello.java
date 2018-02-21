package com.database.systems.fixture.common.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by chris on 2/20/18.
 */

@Entity
@Table(name = "Anello")
public class Anello implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "prezzo_base")
    private double prezzoBase;

    public Anello() {
    }

    public Anello(String id, String nome, double prezzoBase) {
        this.id = id;
        this.nome = nome;
        this.prezzoBase = prezzoBase;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzoBase(double prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    @Override
    public String toString() {
        return "Anello{" +
                "id=" + id +
                "nome=" + nome +
                "prezzo_base=" + prezzoBase +
                '}';
    }

/*

    public static void main(String[] args){

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            @SuppressWarnings("unchecked")
            List<Anello> anello = session.createQuery("FROM Anello").list();
            anello.forEach((x) -> System.out.println("\n\n\n--------- " + x));

            Anello p1 = new Anello("008", "gino", 100.00);
            System.out.println("-- persisting persons --");
            System.out.println(p1);

            session.beginTransaction();
            session.save(p1);
            session.getTransaction().commit();

        }

}
*/


}

