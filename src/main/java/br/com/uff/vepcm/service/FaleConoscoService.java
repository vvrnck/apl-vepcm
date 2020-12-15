package br.com.uff.vepcm.service;

import br.com.uff.vepcm.domain.entity.FaleConosco;

import javax.validation.Valid;
import java.util.List;

public interface FaleConoscoService {

    FaleConosco salvarFaleConosco(@Valid FaleConosco faleConosco);
    FaleConosco buscarPorId(Long id);
    List<FaleConosco> buscarTodosFaleConosco();
    List<FaleConosco> buscarFaleConoscoPorAssunto(String assunto);
    FaleConosco alterarFaleConosco(Long id, @Valid FaleConosco faleConosco);
    void removerFaleConosco(Long id);

}
