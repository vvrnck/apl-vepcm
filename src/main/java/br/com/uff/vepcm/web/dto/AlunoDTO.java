package br.com.uff.vepcm.web.dto;

import br.com.uff.vepcm.domain.entity.Pessoa;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class AlunoDTO {
    private String naturalidade;
    private String nomeMae;
    private String nomePai;
    private Pessoa pessoa;
    private Long idResponsavel;

    public AlunoDTO() {}

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }
}
