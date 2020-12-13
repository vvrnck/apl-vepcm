package br.com.uff.vepcm.service;

import br.com.uff.vepcm.domain.entity.Usuario;

public interface AuthService {
    Usuario login(Usuario usuario);
}
