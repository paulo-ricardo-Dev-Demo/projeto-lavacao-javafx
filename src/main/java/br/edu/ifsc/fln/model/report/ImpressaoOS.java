package br.edu.ifsc.fln.model.report;

import domain.*;
import exceptions.ExceptionLavacao;

public class ImpressaoOS {
    public String imprimirOS(OrdemServico os) throws ExceptionLavacao {
        os.calcularServico();

        //calculando quantos pontos o cliente ganhou
        int pontos = os.getListaItemOS().size() * Servico.getPontos();

        //adicionando os pontos ao cliente
        os.getVeiculo().getProprietario().getPontuacao().adicionar(pontos);

        StringBuilder dados = new StringBuilder();
        dados.append("-".repeat(52)).append("\n");
        dados.append("Número: ").append(os.getNumero()).append("\t\t");
        dados.append("dia: ").append(os.getAgenda()).append("\t\t");
        dados.append("STATUS: ").append(os.getStatus().getNome()).append("\n");
        dados.append("Cliente: ").append(os.getVeiculo().getProprietario().getNome()).append("\t\t");

        if (os.getVeiculo().getProprietario() instanceof PessoaFisica) {
            dados.append("CPF: ").append(((PessoaFisica) os.getVeiculo().getProprietario()).getCpf()).append("\n");
        } else {
            dados.append("CNPJ: ").append(((PessoaJuridica) os.getVeiculo().getProprietario()).getCnpj()).append("\n");
        }

        dados.append("Placa:  ").append(os.getVeiculo().getPlaca()).append("\t\t");
        dados.append("Modelo: ").append(os.getVeiculo().getModelo().getDescricao()).append("\n");
        dados.append("Marca: ").append(os.getVeiculo().getModelo().getMarca().getNome()).append("\t\t");
        dados.append("Cor: ").append(os.getVeiculo().getCor().getNome()).append("\n");
        dados.append("=".repeat(52)).append("\n");
        dados.append("ITEM").append("\t\t").append("DESCRIÇÃO").append("\t\t\t\t").append("VALOR").append("\n");
        dados.append("=".repeat(52)).append("\n");

        int i = 1;
        double subtotal = 0;
        for (ItemOS item : os.getListaItemOS()) {
            dados.append(i).append("\t\t");
            dados.append(item.getServico().getDescricao());
            if (item.getServico().getDescricao().length() >= 20) {
                dados.append("\t\t");
            }
            else if (item.getServico().getDescricao().length() < 15){
                dados.append("\t\t\t\t\t");
            }
            else {
                dados.append("\t\t\t");
            }
            dados.append(item.getValorServico()).append("\n");
            subtotal += item.getValorServico();
            i++;
        }
        dados.append("=".repeat(52)).append("\n");
        dados.append("SUBTOTAL").append("\t\t\t\t\t\t\t").append(subtotal).append("\n");
        dados.append("DESCONTO (").append(os.getDesconto() + "%)").append("\t\t\t\t\t");
        dados.append(os.getDesconto()/100 * subtotal).append("\n");
        dados.append("=".repeat(52)).append("\n");
        dados.append("TOTAL").append("\t\t\t\t\t\t\t\t").append(os.getTotal()).append("\n");
        dados.append("-".repeat(52));
        return dados.toString();
    }
}
