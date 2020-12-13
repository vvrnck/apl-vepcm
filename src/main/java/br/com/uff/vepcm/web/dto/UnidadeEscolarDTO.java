package br.com.uff.vepcm.web.dto;

import br.com.uff.vepcm.domain.entity.Endereco;

import java.util.Set;

public class UnidadeEscolarDTO {
    private Long id;
    private String nome;
    private int numVagas;
    private String data;
    private Endereco endereco;
    private Set<AnoEscolaridadeDTO> anoEscolaridade;

    public UnidadeEscolarDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumVagas() {
        return numVagas;
    }

    public void setNumVagas(int numVagas) {
        this.numVagas = numVagas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Set<AnoEscolaridadeDTO> getAnoEscolaridade() {
        return anoEscolaridade;
    }

    public void setAnoEscolaridade(Set<AnoEscolaridadeDTO> anoEscolaridade) {
        this.anoEscolaridade = anoEscolaridade;
    }
}
