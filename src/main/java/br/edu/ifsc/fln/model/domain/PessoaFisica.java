package br.edu.ifsc.fln.model.domain;

import java.time.LocalDate;

public class PessoaFisica extends Cliente {
    private String cpf;
    private LocalDate dataNascimento;

    public PessoaFisica() {}

    public PessoaFisica(int id, String nome, String celular, String email, String cpf, LocalDate dataNascimento) {
        super(id, nome, celular, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getDados() {
        StringBuilder dados = new StringBuilder();
        dados.append("CPF...................: " + cpf + "\n");
        dados.append("Data de Nascimento....: " + dataNascimento + "\n");
        return super.getDados() + dados.toString();
    }

    @Override
    public String getDados(String observacao) {
        StringBuilder dados = new StringBuilder();
        dados.append("Observação............: " + observacao + "\n");
        return getDados() + dados.toString();
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
