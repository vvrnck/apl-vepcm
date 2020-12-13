package br.com.uff.vepcm.service.impl;


import br.com.uff.vepcm.domain.entity.AnoEscolaridade;
import br.com.uff.vepcm.domain.entity.Endereco;
import br.com.uff.vepcm.domain.entity.UnidadeEscolar;
import br.com.uff.vepcm.domain.entity.UnidadeEscolar;
import br.com.uff.vepcm.domain.repository.UnidadeEscolarRepository;
import br.com.uff.vepcm.service.UnidadeEscolarService;
import br.com.uff.vepcm.web.dto.AnoEscolaridadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    public UnidadeEscolar alterarUE(Long id, @Valid UnidadeEscolar unidadeEscolarAlterado) {
        UnidadeEscolar unidadeEscolar = buscarPorId(id);

        if (Objects.isNull(unidadeEscolar)) return null;

        if (Objects.nonNull(unidadeEscolarAlterado.getNome())) unidadeEscolar.setNome(unidadeEscolarAlterado.getNome());
        if (Objects.nonNull(unidadeEscolarAlterado.getNumVagas())) unidadeEscolar.setNumVagas(unidadeEscolarAlterado.getNumVagas());
        if (Objects.nonNull(unidadeEscolarAlterado.getData())) unidadeEscolar.setData(unidadeEscolarAlterado.getData());
        if (Objects.nonNull(unidadeEscolarAlterado.getEndereco())) unidadeEscolar.setEndereco(unidadeEscolarAlterado.getEndereco());
        if (Objects.nonNull(unidadeEscolarAlterado.getAnoEscolaridade())) unidadeEscolar.setAnoEscolaridade(unidadeEscolarAlterado.getAnoEscolaridade());


        return salvarUE(unidadeEscolar);
    }
}
