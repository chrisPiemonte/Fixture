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
    private double molt;

    @Column(name = "squadra_avversaria")
    private String squadraAvversaria;

    public Partita() {

    }

    public Partita(PartitaId numeroAndStagione, LocalDate data, double molt, String squadraAvversaria) {
        this.numeroAndStagione = numeroAndStagione;
        this.data = data;
        this.molt = molt;
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

    public double getMolt() {
        return molt;
    }

    public void setMolt(double molt) {
        this.molt = molt;
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
                ", molt=" + molt +
                ", squadraAvversaria='" + squadraAvversaria + '\'' +
                '}';
    }
}
