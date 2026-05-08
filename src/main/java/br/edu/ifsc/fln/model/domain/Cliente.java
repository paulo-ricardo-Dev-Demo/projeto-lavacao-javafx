package br.edu.ifsc.fln.model.domain;

import br.edu.ifsc.fln.model.exceptions.ExceptionLavacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente implements IDados {
    protected int id;
    protected String nome;
    protected String celular;
    protected String email;
    protected LocalDate dataCadastro;
    //associação unidirecional com pontuação
    private Pontuacao pontuacao;
    //associação bidirecional com 'Veiculo
    private List<Veiculo> veiculos;

    public Cliente() {
        this.dataCadastro = LocalDate.now();
        this.pontuacao = new Pontuacao();
        this.veiculos = new ArrayList<>();
    }

    public Cliente(int id, String nome, String celular, String email, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = dataCadastro;
        //composição de Pontuacao com Cliente
        this.pontuacao = new Pontuacao();
        this.veiculos = new ArrayList<>();
    }

    @Override
    public String getDados() {
        StringBuilder dados = new StringBuilder();
        dados.append("Nome..................: ").append(nome).append("\n");
        dados.append("Celular...............: ").append(celular).append("\n");
        dados.append("Email.................: ").append(email).append("\n");
        dados.append("Data de Cadastro......: ").append(dataCadastro).append("\n");
        return dados.toString();
    }

    @Override
    public String getDados(String observacao) {
        StringBuilder dados = new StringBuilder();
        dados.append("observacao...............: ").append(observacao).append("\n");

        return getDados() + dados.toString();
    }

    public void add(Veiculo veiculo) {
        if (!(this.veiculos.contains(veiculo))) {
            this.veiculos.add(veiculo);
            veiculo.setCliente(this);
        }
    }

    public void remove(Veiculo veiculo) throws ExceptionLavacao {
        if (!veiculos.contains(veiculo)) {
            throw new ExceptionLavacao("Veículo não encontrado na lista do cliente.");
        }
        this.veiculos.remove(veiculo);
    }

    //getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
