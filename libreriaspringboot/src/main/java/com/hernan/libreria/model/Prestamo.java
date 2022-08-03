package com.hernan.libreria.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;


    private Date inicio ;
    private  Date fin  ;


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="lectorid")
    private Lector lector;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="copiaid")
    private Copia copia;


    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
