package com.database.systems.fixture.common.entity;

import com.database.systems.fixture.common.entity.composite.PartitaId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by chris on 2/20/18.
 */


@Entity
@Table(name = "Partita")
public class Partita implements Serializable {

    @EmbeddedId
    private PartitaId numeroAndStagione;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "molt")
    private double id;

    @Column(name = "squadra_avversaria")
    private String squadraAvversaria;

    public Partita() {

    }

    public Partita(PartitaId numeroAndStagione, LocalDate data, double id, String squadraAvversaria) {
        this.numeroAndStagione = numeroAndStagione;
        this.data = data;
        this.id = id;
        this.squadraAvversaria = squadraAvversaria;
    }

    public PartitaId getNumeroAndStagione() {
        return numeroAndStagione;
    }

    public void setNumeroAndStagione(PartitaId numeroAndStagione) {
        this.numeroAndStagione = numeroAndStagione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getSquadraAvversaria() {
        return squadraAvversaria;
    }

    public void setSquadraAvversaria(String squadraAvversaria) {
        this.squadraAvversaria = squadraAvversaria;
    }

    @Override
    public String toString() {
        return "Partita{" +
                "numeroAndStagione=" + numeroAndStagione +
                ", data=" + data +
                ", id=" + id +
                ", squadraAvversaria='" + squadraAvversaria + '\'' +
                '}';
    }

/*
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            @SuppressWarnings("unchecked")
            List<Partita> partita = session.createQuery("FROM Partita").list();
            partita.forEach((x) -> System.out.println("\n\n\n--------- " + x));

            Partita p1 = new Partita(new PartitaId(11, "1011"), LocalDate.now(), 1.5, "Pisa");
            System.out.println("-- persisting persons --");
            System.out.println(p1);

            session.beginTransaction();
            session.save(p1);
            session.getTransaction().commit();

        }


    }

    */
}
