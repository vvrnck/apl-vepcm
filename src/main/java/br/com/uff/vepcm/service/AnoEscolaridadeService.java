package br.com.uff.vepcm.service;

import br.com.uff.vepcm.domain.entity.AnoEscolaridade;

import javax.validation.Valid;
import java.util.List;

public interface AnoEscolaridadeService {
    AnoEscolaridade salvarAnoEscolaridade(@Valid AnoEscolaridade anoEscolaridade);
    AnoEscolaridade buscarPorId(Long id);
    AnoEscolaridade alterarAnoEscolaridade(Long id, @Valid AnoEscolaridade anoEscolaridade);
    List<AnoEscolaridade> buscarTodos();
    void removerAnoEscolaridade(Long id);
}
