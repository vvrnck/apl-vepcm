package br.com.uff.vepcm.web.dto;

public class AnoEscolaridadeDTO {
    private Long id;
    private String nome;
    private String descricao;

    public AnoEscolaridadeDTO() {}

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
