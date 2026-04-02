package br.edu.ifsc.fln.model.domain;

import java.util.Objects;

public class Cor {
    private long id;
    private String nome;

    //Métodos construtores
    public Cor() {}

    public Cor(String nome) {
        this.nome = nome;
    }

    public Cor(long id, String nome) {
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
        return "domain.Cor{" +
                ", nome='" + nome + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Cor cor = (Cor) object;
        return id == cor.id;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}

