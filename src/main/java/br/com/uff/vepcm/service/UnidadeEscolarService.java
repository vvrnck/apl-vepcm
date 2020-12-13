package br.com.uff.vepcm.service;

import br.com.uff.vepcm.domain.entity.UnidadeEscolar;
import javax.validation.Valid;
import java.util.List;

public interface UnidadeEscolarService {
    UnidadeEscolar salvarUE(@Valid UnidadeEscolar unidadeEscolar);
    UnidadeEscolar buscarPorId(Long id);
    List<UnidadeEscolar> buscarTodas();
    void removerUE(Long id);
    UnidadeEscolar alterarUE(Long id, @Valid UnidadeEscolar unidadeEscolar);
}
