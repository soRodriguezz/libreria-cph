package com.hernan.libreria.model;



import javax.persistence.*;
import java.util.List;


@Entity
public class Copia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private String estado;

    @ManyToOne(fetch  = FetchType.LAZY)
    @JoinColumn(name = "libroid")
    private Libro libro;

    @OneToMany(mappedBy ="copia")
    private List<Prestamo> prestamos;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
