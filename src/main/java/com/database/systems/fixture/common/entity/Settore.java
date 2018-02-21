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
@Table(name = "Settore")
public class Settore implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "prezzo_base")
    private double prezzoBase;

    public Settore() {
    }

    public Settore(String id, String nome, double prezzoBase) {
        this.id = id;
        this.nome = nome;
        this.prezzoBase = prezzoBase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoBase(double prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    @Override
    public String toString() {
        return "Settore{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", prezzoBase=" + prezzoBase +
                '}';
    }


    public static void main(String[] args){

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            @SuppressWarnings("unchecked")
            List<Settore> settore = session.createQuery("FROM Settore").list();
            settore.forEach((x) -> System.out.println("\n\n\n--------- " + x));

            Settore p1 = new Settore("00r", "gino", 100.00);
            System.out.println("-- persisting persons --");
            System.out.println(p1);

            session.beginTransaction();
            session.save(p1);
            session.getTransaction().commit();

        }

    }

}
