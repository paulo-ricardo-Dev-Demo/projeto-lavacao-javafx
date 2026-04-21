package br.edu.ifsc.fln.model.domain;

public enum ECategoria {
    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande"),
    MOTO("Moto"),
    PADRAO("Padrão");

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
