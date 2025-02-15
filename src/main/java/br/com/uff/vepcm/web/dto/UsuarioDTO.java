package br.com.uff.vepcm.web.dto;

import br.com.uff.vepcm.domain.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {
    public Long id;
    @Email
    public String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String senha;
    private TipoUsuario tipoUsuario;
    private PessoaDTO pessoa;

    public UsuarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public PessoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }
}
