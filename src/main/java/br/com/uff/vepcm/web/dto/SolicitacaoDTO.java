package br.com.uff.vepcm.web.dto;

import br.com.uff.vepcm.domain.entity.Aluno;
import br.com.uff.vepcm.domain.entity.AnoEscolaridade;
import br.com.uff.vepcm.domain.entity.UnidadeEscolar;
import br.com.uff.vepcm.domain.entity.Usuario;

import javax.persistence.*;

public class SolicitacaoDTO {

    private Long id;
    private String protocolo;
    private String data;
    private Usuario Responsavel;
    private Aluno Aluno;
    private UnidadeEscolar UnidadeEscolar;

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

    public Usuario getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        Responsavel = responsavel;
    }

    public Aluno getAluno() {
        return Aluno;
    }

    public void setAluno(Aluno aluno) {
        Aluno = aluno;
    }


    public UnidadeEscolar getUnidadeEscolar() {
        return UnidadeEscolar;
    }

    public void setUnidadeEscolar(UnidadeEscolar unidadeEscolar) {
        UnidadeEscolar = unidadeEscolar;
    }
}
