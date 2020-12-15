package br.com.uff.vepcm.domain.entity;

import javax.persistence.*;

@Entity
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String protocolo;
    private String data;
    private Long idResponsavel;
    @OneToOne(cascade = CascadeType.ALL)
    private Aluno aluno;
   /* @OneToOne(cascade = CascadeType.ALL)
    private AnoEscolaridade AnoEscolaridade;*/
    @OneToOne(cascade = CascadeType.ALL)
    private UnidadeEscolar unidadeEscolar;


    public Solicitacao(){}

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

    /*public br.com.uff.vepcm.domain.entity.AnoEscolaridade getAnoEscolaridade() {
        return AnoEscolaridade;
    }

    public void setAnoEscolaridade(br.com.uff.vepcm.domain.entity.AnoEscolaridade anoEscolaridade) {
        AnoEscolaridade = anoEscolaridade;
    }*/

    public UnidadeEscolar getUnidadeEscolar() {
        return unidadeEscolar;
    }

    public void setUnidadeEscolar(UnidadeEscolar unidadeEscolar) {
        this.unidadeEscolar = unidadeEscolar;
    }
}
