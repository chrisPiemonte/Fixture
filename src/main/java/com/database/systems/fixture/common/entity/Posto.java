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
}
