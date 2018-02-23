package com.database.systems.fixture.common.entity;

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
@Table(name = "Persona")
public class Persona implements Serializable {

    @Id
    @Column(name = "cf")
    private String cf;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate data_nascita;

    @Column(name = "luogo_nascita")
    private String luogo_nascita;

    @Column(name = "telefono")
    private String telefono;

    public Persona() {
    }

    public Persona(String cf, String tipo, String nome, String cognome,
                   LocalDate data_nascita, String luogo_nascita, String telefono) {
        this.cf = cf;
        this.tipo = tipo;
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.luogo_nascita = luogo_nascita;
        this.telefono = telefono;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getLuogo_nascita() {
        return luogo_nascita;
    }

    public void setLuogo_nascita(String luogo_nascita) {
        this.luogo_nascita = luogo_nascita;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "cf='" + cf + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                ", luogo_nascita='" + luogo_nascita + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
