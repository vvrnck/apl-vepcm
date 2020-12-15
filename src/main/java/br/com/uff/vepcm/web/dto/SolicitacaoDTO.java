package br.com.uff.vepcm.web.dto;

import br.com.uff.vepcm.domain.entity.Aluno;
import br.com.uff.vepcm.domain.entity.AnoEscolaridade;
import br.com.uff.vepcm.domain.entity.UnidadeEscolar;


public class SolicitacaoDTO {

    private Long id;
    private String protocolo;
    private String data;
    private Long idResponsavel;
    private Long idAluno;
    private Long idAnoEscolaridade;
    private Long idUnidadeEscolar;

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

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public Long getIdAnoEscolaridade() {
        return idAnoEscolaridade;
    }

    public void setIdAnoEscolaridade(Long idAnoEscolaridade) {
        this.idAnoEscolaridade = idAnoEscolaridade;
    }

    public Long getIdUnidadeEscolar() {
        return idUnidadeEscolar;
    }

    public void setIdUnidadeEscolar(Long idUnidadeEscolar) {
        this.idUnidadeEscolar = idUnidadeEscolar;
    }
}
