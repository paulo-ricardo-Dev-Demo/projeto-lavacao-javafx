package br.edu.ifsc.fln.model.domain;

import java.util.Objects;

public class Modelo {
    private int id;
    private String descricao;

    //enum
    private ECategoria categoria;

    //agregação
    private Motor motor = new Motor();

    //unidirecional
    private Marca marca = new Marca();

    public Modelo() {}

    public Modelo (String descricao,Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
    }

    public Modelo (int id, String descricao, Marca marca, ECategoria categoria,
                   int potencia, ETipoCombustivel tipoCombustivel) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.motor.setPotencia(potencia);
        this.motor.setTipoCombustivel(tipoCombustivel);
        this.marca = marca;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public ECategoria getCategoria() {
        return categoria;
    }

    public Motor getMotor() {
        return motor;
    }

    public Marca getMarca() {
        return marca;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setCategoria(ECategoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "domain.Modelo{" +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", motor=" + motor +
                ", marca=" + marca +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Modelo modelo = (Modelo) o;
        return id == modelo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}