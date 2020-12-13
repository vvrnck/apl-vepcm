package br.com.uff.vepcm.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UnidadeEscolar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int numVagas;
    private String data;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<AnoEscolaridade> anoEscolaridade;

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

    public Set<AnoEscolaridade> getAnoEscolaridade() {
        return anoEscolaridade;
    }

    public void setAnoEscolaridade(Set<AnoEscolaridade> anoEscolaridade) {
        this.anoEscolaridade = anoEscolaridade;
    }
}
