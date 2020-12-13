package br.com.uff.vepcm.service;

import br.com.uff.vepcm.domain.entity.Usuario;
import javax.validation.Valid;
import java.util.List;

public interface UsuarioService {
    List<Usuario> buscarTodosUsuarios();
    Usuario salvarUsuario(@Valid Usuario usuario);
    Usuario buscarPorId(Long id);
    Usuario alterarUsuario(Long id, @Valid Usuario usuario);
    void removerUsuario(Long id);
}
