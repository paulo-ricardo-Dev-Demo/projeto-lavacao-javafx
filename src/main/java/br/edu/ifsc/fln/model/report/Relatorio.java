package br.edu.ifsc.fln.model.report;

import domain.Cliente;
import domain.PessoaFisica;
import domain.PessoaJuridica;

public class Relatorio {
    public String imprimir(Cliente cliente) {
        StringBuilder dados = new StringBuilder();
        dados.append("=".repeat(50)).append("\n");

        dados.append("Nome..................: ").append(cliente.getNome()).append("\n");
        if (cliente instanceof PessoaJuridica) {
            dados.append("Cnpj..................: ").append(((PessoaJuridica) cliente).getCnpj()).append("\n");
        }
        else {
            dados.append("Cpf...................: ").append(((PessoaFisica) cliente).getCpf()).append("\n");
        }
        dados.append("Saldo de pontos.......: ").append(cliente.getPontuacao().saldo()).append("\n");
        dados.append("Lista de veículos.....:").append("\n");

        if (cliente.getVeiculos().isEmpty())  {
            dados.append("\nNão há nenhum veículo vinculado à este cliente.");
        }
        else {
            for (int i = 0; i < cliente.getVeiculos().size(); i++) {
                dados.append("\n");
                dados.append((i + 1) + "º veículo: ").append("\n\n");
                dados.append(cliente.getVeiculos().get(i).getDados()).append("\n");
            }
        }
        dados.append("\n").append("=".repeat(50));

        return  dados.toString();
    }
}
