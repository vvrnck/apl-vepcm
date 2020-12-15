package br.com.uff.vepcm.web.dto;

import br.com.uff.vepcm.domain.entity.Aluno;

import java.util.Set;

public class ListaEsperaDTO {

    private Long id;
    private String data;
    private Set<Aluno> aluno;

    public ListaEsperaDTO(){  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Set<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(Set<Aluno> aluno) {
        this.aluno = aluno;
    }

}
