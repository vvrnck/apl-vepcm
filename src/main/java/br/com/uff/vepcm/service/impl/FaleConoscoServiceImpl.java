
package br.com.uff.vepcm.service.impl;

import br.com.uff.vepcm.domain.entity.*;
import br.com.uff.vepcm.domain.repository.FaleConoscoRepository;
import br.com.uff.vepcm.service.FaleConoscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Service
public class FaleConoscoServiceImpl implements FaleConoscoService {

    @Autowired
    FaleConoscoRepository faleConoscoRepository;

    @Transactional
    @Override
    public FaleConosco salvarFaleConosco(@Valid FaleConosco faleConosco) {
        return faleConoscoRepository.save(faleConosco);
    }

    @Override
    public List<FaleConosco> buscarTodosFaleConosco() { return faleConoscoRepository.findAll(); };

    @Override
    public void removerFaleConosco(Long id) { faleConoscoRepository.deleteById(id); };

    @Override
    public FaleConosco buscarPorId(Long id) { return faleConoscoRepository.findById(id).orElse(null); };

    @Override
    public List<FaleConosco> buscarFaleConoscoPorAssunto(String assunto) {
        return faleConoscoRepository.buscarFaleConoscoPorAssunto(assunto);
    }

    @Transactional
    @Override
    public FaleConosco alterarFaleConosco(Long id, @Valid FaleConosco faleConoscoAlterado) {
        FaleConosco faleConosco = buscarPorId(id);

        if (Objects.isNull(faleConosco)) return null;

        if (Objects.nonNull(faleConoscoAlterado.getId())) faleConosco.setId(faleConoscoAlterado.getId());
        if (Objects.nonNull(faleConoscoAlterado.getData())) faleConosco.setData(faleConoscoAlterado.getData());
        if (Objects.nonNull(faleConoscoAlterado.getAssunto())) faleConosco.setAssunto(faleConoscoAlterado.getAssunto());
        if (Objects.nonNull(faleConoscoAlterado.getTexto())) faleConosco.setTexto(faleConoscoAlterado.getTexto());
        if (Objects.nonNull(faleConoscoAlterado.getIdUsuario())) faleConosco.setIdUsuario(faleConoscoAlterado.getIdUsuario());
        return salvarFaleConosco(faleConosco);
    }

}

