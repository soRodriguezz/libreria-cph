package com.hernan.libreria.model;

public class LibroTotal {
    Libro libro;
    Categoria categoria;
    Autor autor;

    public LibroTotal(Libro libro, Categoria categoria, Autor autor) {
        this.libro = libro;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
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
}
