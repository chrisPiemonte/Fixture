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
@Table(name = "squadra_avversaria")
public class SquadraAvversaria implements Serializable {

    @Id
    @Column(name = "nome")
    private String nome;

    @Column(name = "citta")
    private String citta;

    public SquadraAvversaria() {
    }

    public SquadraAvversaria(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "SquadraAvversaria{" +
                "nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }

    /*
    public static void main(String[] args){

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            @SuppressWarnings("unchecked")
            List<SquadraAvversaria> squadraAvversaria = session.createQuery("FROM SquadraAvversaria").list();
            squadraAvversaria.forEach((x) -> System.out.println("\n\n\n--------- " + x));

            SquadraAvversaria p1 = new SquadraAvversaria("tino", "citta");
            System.out.println("-- persisting persons --");
            System.out.println(p1);

            session.beginTransaction();
            session.save(p1);
            session.getTransaction().commit();

        }

    }
    */

}
