package br.edu.ifsc.fln.model.domain;

public enum ETipoCombustivel {
    GASOLINA("GASOLINA"),
    ETANOL("ETANOL"),
    FLEX("FLEX"),
    DIESEL("DIESEL"),
    GNV("GNV"),
    OUTRO("OUTRO");

    private String nome;

    private ETipoCombustivel(String nome) {
        this.nome = nome;
    }
}
