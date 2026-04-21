package br.edu.ifsc.fln.model.domain;

public class PessoaJuridica extends Cliente{
    private String cnpj;
    private String inscricaoEstadual;

    public PessoaJuridica() {}

    public PessoaJuridica(int id, String nome, String celular, String email, String cnpj, String inscricaoEstadual) {
        super(id, nome, celular, email);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String getDados() {
        StringBuilder dados = new StringBuilder();
        dados.append("CNPJ..................: " + cnpj + "\n");
        dados.append("Inscricao Estadual....: " + inscricaoEstadual + "\n");
        return super.getDados() + dados.toString();
    }

    @Override
    public String getDados(String observacao) {
        StringBuilder dados = new StringBuilder();
        dados.append("Observação............: " + observacao + "\n");
        return getDados() + dados.toString();
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}
