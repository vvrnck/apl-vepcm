package br.com.uff.vepcm.service.impl;

import br.com.uff.vepcm.domain.entity.AnoEscolaridade;
import br.com.uff.vepcm.domain.entity.AnoEscolaridade;
import br.com.uff.vepcm.domain.repository.AnoEscolaridadeRepository;
import br.com.uff.vepcm.domain.repository.AnoEscolaridadeRepository;
import br.com.uff.vepcm.service.AnoEscolaridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Service
public class AnoEscolaridadeServiceImpl implements AnoEscolaridadeService {

    @Autowired
    AnoEscolaridadeRepository anoEscolaridadeRepository;

    @Transactional
    @Override
    public AnoEscolaridade salvarAnoEscolaridade(@Valid AnoEscolaridade anoEscolaridade) {
        return anoEscolaridadeRepository.save(anoEscolaridade);
    }

    @Override
    public List<AnoEscolaridade> buscarTodos() { return anoEscolaridadeRepository.findAll(); };

    @Override
    public void removerAnoEscolaridade(Long id) { anoEscolaridadeRepository.deleteById(id); };

    @Override
    public AnoEscolaridade buscarPorId(Long id) { return anoEscolaridadeRepository.findById(id).orElse(null); };

//    @Override
//    public List<AnoEscolaridade> buscaAnoEscolaridadesPorResponsavel(Long id) {
//        return anoEscolaridadeRepository.buscaAnoEscolaridadesPorResponsavel(id);
//    }

    @Transactional
    @Override
    public AnoEscolaridade alterarAnoEscolaridade(Long id, @Valid AnoEscolaridade anoEscolaridadeAlterado) {
        AnoEscolaridade anoEscolaridade = buscarPorId(id);

        if (Objects.isNull(anoEscolaridade)) return null;

        if (Objects.nonNull(anoEscolaridadeAlterado.getNome())) anoEscolaridade.setNome(anoEscolaridadeAlterado.getNome());
        if (Objects.nonNull(anoEscolaridadeAlterado.getDescricao())) anoEscolaridade.setDescricao(anoEscolaridadeAlterado.getDescricao());
        return salvarAnoEscolaridade(anoEscolaridade);
    }
}
