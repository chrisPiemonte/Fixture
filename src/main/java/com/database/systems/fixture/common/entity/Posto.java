package com.database.systems.fixture.common.entity;

import com.database.systems.fixture.common.entity.composite.PartitaId;
import com.database.systems.fixture.common.entity.composite.PostoId;
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
@Table(name = "Posto")
public class Posto implements Serializable {

    @EmbeddedId
    private PostoId numeroSettoreAnello;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "prezzo")
    private double prezzo;

    public Posto() {
    }

    public Posto(PostoId numeroSettoreAnello, String tipo, double prezzo) {
        this.numeroSettoreAnello = numeroSettoreAnello;
        this.tipo = tipo;
        this.prezzo = prezzo;
    }

    public Posto(PostoId numeroSettoreAnello, String tipo) {
        this.numeroSettoreAnello = numeroSettoreAnello;
        this.tipo = tipo;
    }

    public PostoId getNumeroSettoreAnello() {
        return numeroSettoreAnello;
    }

    public void setNumeroSettoreAnello(PostoId numeroSettoreAnello) {
        this.numeroSettoreAnello = numeroSettoreAnello;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Posto{" +
                "numeroSettoreAnello=" + numeroSettoreAnello +
                ", tipo='" + tipo + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
/*

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            @SuppressWarnings("unchecked")
            List<Posto> posto = session.createQuery("FROM Posto").list();
            posto.forEach((x) -> System.out.println("\n\n\n--------- " + x));

            Posto p1 = new Posto(new PostoId(12, "005", "005"), "PRESIDENTE", 40.00);
            System.out.println("-- persisting persons --");
            System.out.println(p1);

            session.beginTransaction();
            session.save(p1);
            session.getTransaction().commit();

        }


    }

    */
}
