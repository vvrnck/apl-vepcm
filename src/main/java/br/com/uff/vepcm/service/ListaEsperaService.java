package br.com.uff.vepcm.service;

import br.com.uff.vepcm.domain.entity.ListaEspera;
import javax.validation.Valid;
import java.util.List;

public interface ListaEsperaService {

    ListaEspera salvarListaEspera(@Valid ListaEspera listaEspera);
    ListaEspera buscarPorId(Long id);
    List<ListaEspera> buscarTodasListasEspera();
    List<ListaEspera> buscarListasEsperaPorData(String data);
    ListaEspera alterarListaEspera(Long id, @Valid ListaEspera listaEspera);
    void removerListaEspera(Long id);

}
