package br.com.uff.vepcm.service.impl;

import br.com.uff.vepcm.domain.entity.Pessoa;
import br.com.uff.vepcm.domain.entity.Usuario;
import br.com.uff.vepcm.domain.repository.PessoaRepository;
import br.com.uff.vepcm.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa salvarPessoa(@Valid Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


    @Override
    public Pessoa buscarPessoaPorId(Long id) {
        Pessoa p = pessoaRepository.findById(id).orElse(null);
        return p;
    }


}
