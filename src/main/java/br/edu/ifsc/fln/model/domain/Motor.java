package br.edu.ifsc.fln.model.domain;

public class Motor {
    private int potencia;

    //enum
    private ETipoCombustivel tipoCombustivel;

    //GETTERS
    public int getPotencia() {
        return potencia;
    }

    public ETipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    //SETTERS
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setTipoCombustivel(ETipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public String toString() {
        return "domain.Motor{" +
                "potencia=" + potencia +
                ", tipoCombustivel=" + tipoCombustivel +
                '}';
    }
}
