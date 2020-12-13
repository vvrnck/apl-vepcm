package br.com.uff.vepcm.service;

import br.com.uff.vepcm.domain.entity.Pessoa;

public interface PessoaService {
    Pessoa buscarPessoaPorId(Long id);
}
