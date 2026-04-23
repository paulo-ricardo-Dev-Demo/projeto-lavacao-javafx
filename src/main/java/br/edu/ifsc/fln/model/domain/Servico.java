package br.edu.ifsc.fln.model.domain;

import java.util.Objects;

public class Servico {
    private int id;
    private String descricao;
    private double valor;

    private static int pontos;

    private ECategoria categoria;

    public Servico() {
    }

    public Servico(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Servico(String descricao, double valor, ECategoria categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        Servico.pontos = pontos;
    }

    public ECategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ECategoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return id == servico.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
