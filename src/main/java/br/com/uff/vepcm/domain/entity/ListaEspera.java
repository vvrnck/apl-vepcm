package br.com.uff.vepcm.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ListaEspera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Aluno> aluno;

    public ListaEspera() {  }

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
