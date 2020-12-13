package br.com.uff.vepcm.service.impl;


import br.com.uff.vepcm.domain.entity.UnidadeEscolar;
import br.com.uff.vepcm.domain.repository.UnidadeEscolarRepository;
import br.com.uff.vepcm.service.UnidadeEscolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
public class UnidadeEscolarServiceImpl implements UnidadeEscolarService {
    @Autowired
    UnidadeEscolarRepository unidadeEscolarRepository;

    @Transactional
    @Override
    public UnidadeEscolar salvarUE(@Valid UnidadeEscolar unidadeEscolar) {
        return unidadeEscolarRepository.save(unidadeEscolar);
    }

    @Override
    public UnidadeEscolar buscarPorId(Long id) {
        UnidadeEscolar ue = unidadeEscolarRepository.findById(id).orElse(null);
        return ue;
    }

    @Override
    public List<UnidadeEscolar> buscarTodas() {
        List<UnidadeEscolar> ues = unidadeEscolarRepository.findAll();
        return ues;
    }

    @Override
    public void removerUE(Long id) {
        unidadeEscolarRepository.deleteById(id);
    }

    @Transactional
    @Override
    public UnidadeEscolar alterarUE(Long id, @Valid UnidadeEscolar unidadeEscolar) {
        return null;
    }
}
