package com.database.systems.fixture.common.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by chris on 2/20/18.
 */


//@SQLInsert(sql="INSERT INTO biglietto (prezzo_totale, ora_acquisto, stagione, partita, posto, settore, anello, " +
 //       "septtatore, compratore) value (?, ?, ?, ?, ?, ?, ?, ?)", check= ResultCheckStyle.COUNT)
@Entity
@Table(name = "Biglietto")
public class Biglietto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "prezzo_totale", nullable = true)
    private double prezzoTotale;

    @Column(name = "ora_acquisto")
    private Timestamp oraAcquisto;

    @Column(name = "stagione", nullable = false)
    private String stagione;

    @Column(name = "partita", nullable = false)
    private int partita;

    @Column(name = "posto", nullable = false)
    private int posto;

    @Column(name = "settore", nullable = false)
    private String settore;

    @Column(name = "anello", nullable = false)
    private String anello;

    @Column(name = "spettatore", nullable = false)
    private String spettatore;

    @Column(name = "compratore", nullable = false)
    private String compratore;

    public Biglietto() {
    }

    public Biglietto(double prezzoTotale, Timestamp oraAcquisto, String stagione, int partita,
                     int posto, String settore, String anello, String spettatore, String compratore) {
        this.prezzoTotale = prezzoTotale;
        this.oraAcquisto = oraAcquisto;
        this.stagione = stagione;
        this.partita = partita;
        this.posto = posto;
        this.settore = settore;
        this.anello = anello;
        this.spettatore = spettatore;
        this.compratore = compratore;
    }

    public Biglietto(Timestamp oraAcquisto, String stagione, int partita, int posto,
                     String settore, String anello, String spettatore, String compratore) {
        this.oraAcquisto = oraAcquisto;
        this.stagione = stagione;
        this.partita = partita;
        this.posto = posto;
        this.settore = settore;
        this.anello = anello;
        this.spettatore = spettatore;
        this.compratore = compratore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public Timestamp getOraAcquisto() {
        return oraAcquisto;
    }

    public void setOraAcquisto(Timestamp oraAcquisto) {
        this.oraAcquisto = oraAcquisto;
    }

    public String getStagione() {
        return stagione;
    }

    public void setStagione(String stagione) {
        this.stagione = stagione;
    }

    public int getPartita() {
        return partita;
    }

    public void setPartita(int partita) {
        this.partita = partita;
    }

    public int getPosto() {
        return posto;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }

    public String getSettore() {
        return settore;
    }

    public void setSettore(String settore) {
        this.settore = settore;
    }

    public String getAnello() {
        return anello;
    }

    public void setAnello(String anello) {
        this.anello = anello;
    }

    public String getSpettatore() {
        return spettatore;
    }

    public void setSpettatore(String spettatore) {
        this.spettatore = spettatore;
    }

    public String getCompratore() {
        return compratore;
    }

    public void setCompratore(String compratore) {
        this.compratore = compratore;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "id='" + id + '\'' +
                ", prezzoTotale='" + prezzoTotale + '\'' +
                ", oraAcquisto='" + oraAcquisto + '\'' +
                ", stagione='" + stagione + '\'' +
                ", partita='" + partita + '\'' +
                ", posto='" + posto + '\'' +
                ", settore='" + settore + '\'' +
                ", anello='" + anello + '\'' +
                ", spettatore='" + spettatore + '\'' +
                ", compratore='" + compratore + '\'' +
                '}';
    }
}
