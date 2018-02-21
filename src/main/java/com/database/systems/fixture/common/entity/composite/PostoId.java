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

    @Override
    public String toString() {
        return "PostoId{" +
                "numero=" + numero +
                ", settore='" + settore + '\'' +
                ", anello='" + anello + '\'' +
                '}';
    }
}
