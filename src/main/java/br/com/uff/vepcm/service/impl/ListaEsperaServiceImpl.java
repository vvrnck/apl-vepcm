
package br.com.uff.vepcm.service.impl;

import br.com.uff.vepcm.domain.entity.*;
import br.com.uff.vepcm.domain.repository.ListaEsperaRepository;
import br.com.uff.vepcm.service.ListaEsperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Service
public class ListaEsperaServiceImpl implements ListaEsperaService {

    @Autowired
    ListaEsperaRepository listaEsperaRepository;

    @Transactional
    @Override
    public ListaEspera salvarListaEspera(@Valid ListaEspera listaEspera) {
        return listaEsperaRepository.save(listaEspera);
    }

    @Override
    public List<ListaEspera> buscarTodasListasEspera() { return listaEsperaRepository.findAll(); };

    @Override
    public void removerListaEspera(Long id) { listaEsperaRepository.deleteById(id); };

    @Override
    public ListaEspera buscarPorId(Long id) { return listaEsperaRepository.findById(id).orElse(null); };

    @Override
    public List<ListaEspera> buscarListasEsperaPorData(String data) {
        return listaEsperaRepository.buscarListasEsperaPorData(data);
    }


    @Transactional
    @Override
    public ListaEspera alterarListaEspera(Long id, @Valid ListaEspera listaEsperaAlterado) {
        ListaEspera listaEspera = buscarPorId(id);

        if (Objects.isNull(listaEspera)) return null;

        if (Objects.nonNull(listaEsperaAlterado.getData())) listaEspera.setData(listaEsperaAlterado.getData());
        //if (Objects.nonNull(listaEsperaAlterado.getAluno())) listaEspera.setAluno(listaEsperaAlterado.getAluno());
        return salvarListaEspera(listaEspera);
    }

}

