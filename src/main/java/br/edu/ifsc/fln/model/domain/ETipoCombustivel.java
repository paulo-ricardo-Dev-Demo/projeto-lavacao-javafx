package br.edu.ifsc.fln.model.domain;

public enum ETipoCombustivel {
    GASOLINA("Gasolina"),
    ETANOL("Etanol"),
    FLEX("Flex"),
    DIESEL("Diesel"),
    GNV("GNV"),
    OUTRO("Outro");

    private String nome;

    private ETipoCombustivel(String nome) {
        this.nome = nome;
    }
}
