package br.edu.ifsc.fln.model.domain;

public enum ECategoria {
    PEQUENO("PEQUENO"),
    MEDIO("MEDIO"),
    GRANDE("GRANDE"),
    MOTO("MOTO"),
    PADRAO("PADRAO");

    private String tamanho;

    ECategoria(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
