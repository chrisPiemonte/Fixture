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
}
