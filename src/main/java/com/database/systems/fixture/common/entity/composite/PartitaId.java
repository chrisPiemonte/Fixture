package com.database.systems.fixture.common.entity.composite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by chris on 2/20/18.
 */
@Embeddable
public class PartitaId implements Serializable {

    @Column(name = "numero")
    private int numero;

    @Column(name = "stagione")
    private String stagione;

    public PartitaId(){

    }

    public PartitaId(int numero, String stagione) {
        this.numero = numero;
        this.stagione = stagione;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getStagione() {
        return stagione;
    }

    public void setStagione(String stagione) {
        this.stagione = stagione;
    }

    @Override
    public String toString() {
        return "PartitaId{" +
                "numero=" + numero +
                ", stagione='" + stagione + '\'' +
                '}';
    }
}

