package com.hernan.libreria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private String titulo;

    private Date year ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "categoriaid")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "autorid")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Autor autor;


    @OneToMany(mappedBy = "libro")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Copia> copia;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Copia> getCopia() {
        return copia;
    }

    public void setCopia(List<Copia> copia) {
        this.copia = copia;
    }
}
