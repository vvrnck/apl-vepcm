package br.com.uff.vepcm.web.dto;

import br.com.uff.vepcm.domain.entity.Aluno;
import br.com.uff.vepcm.domain.entity.UnidadeEscolar;


public class SolicitacaoDTO {

    private Long id;
    private String protocolo;
    private String data;
    private Long idResponsavel;
    private Aluno aluno;
    private UnidadeEscolar unidadeEscolar;

    SolicitacaoDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public UnidadeEscolar getUnidadeEscolar() {
        return unidadeEscolar;
    }

    public void setUnidadeEscolar(UnidadeEscolar unidadeEscolar) {
        this.unidadeEscolar = unidadeEscolar;
    }
}
