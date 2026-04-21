package br.edu.ifsc.fln.model.domain;

import br.edu.ifsc.fln.model.exceptions.ExceptionLavacao;

public class Pontuacao {
    private int quantidade = 0;

    public int adicionar(int quantidade) {
        this.quantidade += quantidade;
        return this.quantidade;
    }

    public int subtrair(int quantidade) throws ExceptionLavacao {
        if (quantidade > this.quantidade) {
            throw new ExceptionLavacao("Quantidade de ponto a ser subtraído possui um valor invalído.\n" +
                    "Quantidade de pontos disponíveis: " + (this.quantidade));
        }
        else {
            this.quantidade -= quantidade;
        }
        return this.quantidade;
    }

    public int saldo() {
        return quantidade;
    }
}
