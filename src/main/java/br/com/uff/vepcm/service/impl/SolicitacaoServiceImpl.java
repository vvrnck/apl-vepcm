package br.com.uff.vepcm.service.impl;

import br.com.uff.vepcm.domain.entity.*;
import br.com.uff.vepcm.domain.repository.SolicitacaoRepository;
import br.com.uff.vepcm.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

    @Service
    public class SolicitacaoServiceImpl implements SolicitacaoService {

        @Autowired
        SolicitacaoRepository solicitacaoRepository;

        @Transactional
        @Override
        public Solicitacao salvarSolicitacao(@Valid Solicitacao solicitacao) {
            return solicitacaoRepository.save(solicitacao);
        }

        @Override
        public List<Solicitacao> buscarTodasSolicitacoes() { return solicitacaoRepository.findAll(); };

        @Override
        public void removerSolicitacao(Long id) { solicitacaoRepository.deleteById(id); };

        @Override
        public Solicitacao buscarPorId(Long id) { return solicitacaoRepository.findById(id).orElse(null); };

        @Override
        public List<Solicitacao> buscarSolicitacoesPorProtocolo(String id) {
            return solicitacaoRepository.buscarSolicitacoesPorProtocolo(id);
        }

        @Override
        public List<Solicitacao> buscarSolicitacoesPorResponsavel(Long id) {
            return solicitacaoRepository.buscarSolicitacoesPorResponsavel(id);
        }


        @Transactional
        @Override
        public Solicitacao alterarSolicitacao(Long id, @Valid Solicitacao solicitacaoAlterado) {
            Solicitacao solicitacao = buscarPorId(id);

            if (Objects.isNull(solicitacao)) return null;

            if (Objects.nonNull(solicitacaoAlterado.getProtocolo())) solicitacao.setProtocolo(solicitacaoAlterado.getProtocolo());
            if (Objects.nonNull(solicitacaoAlterado.getData())) solicitacao.setData(solicitacaoAlterado.getData());
//            if (Objects.nonNull(solicitacaoAlterado.getIdResponsavel())) solicitacao.setIdResponsavel(solicitacaoAlterado.getIdResponsavel());
//            if (Objects.nonNull(solicitacaoAlterado.getAluno())) solicitacao.setAluno(solicitacaoAlterado.getAluno());
//            if (Objects.nonNull(solicitacaoAlterado.getAnoEscolaridade())) solicitacao.setAnoEscolaridade(solicitacaoAlterado.getAnoEscolaridade());
            //if (Objects.nonNull(solicitacaoAlterado.getUnidadeEscolar())) solicitacao.setUnidadeEscolar(solicitacaoAlterado.getUnidadeEscolar());
            return salvarSolicitacao(solicitacao);
        }

}
