package br.edu.ifsc.fln.model.domain;

import java.util.Objects;

public class Marca {
    private long id;
    private String nome;

    //Métodos construtores
    public Marca() {}

    public Marca(String nome) {
        this.nome = nome;
    }

    public Marca(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //Getters
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    //Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Marca{" +
                ", marca='" + nome + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Marca marca = (Marca) object;
        return id == marca.id;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}

