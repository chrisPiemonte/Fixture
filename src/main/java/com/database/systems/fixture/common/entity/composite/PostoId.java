package com.database.systems.fixture.common.entity.composite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by chris on 2/21/18.
 */

@Embeddable
public class PostoId implements Serializable {

    @Column(name = "numero")
    private int numero;

    @Column(name = "settore")
    private String settore;

    @Column(name = "anello")
    private String anello;

    public PostoId() {
    }

    public PostoId(int numero, String settore, String anello) {
        this.numero = numero;
        this.settore = settore;
        this.anello = anello;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    @Override
    public String toString() {
        return "PostoId{" +
                "numero=" + numero +
                ", settore='" + settore + '\'' +
                ", anello='" + anello + '\'' +
                '}';
    }
}
