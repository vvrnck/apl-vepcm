package br.com.uff.vepcm.service;

import br.com.uff.vepcm.domain.entity.Solicitacao;
import javax.validation.Valid;
import java.util.List;

public interface SolicitacaoService {

        Solicitacao salvarSolicitacao(@Valid Solicitacao solicitacao);
        Solicitacao buscarPorId(Long id);
        List<Solicitacao> buscarTodasSolicitacoes();
        List<Solicitacao> buscarSolicitacoesPorProtocolo(String id);
        Solicitacao alterarSolicitacao(Long id, @Valid Solicitacao solicitacao);
        void removerSolicitacao(Long id);

    }

