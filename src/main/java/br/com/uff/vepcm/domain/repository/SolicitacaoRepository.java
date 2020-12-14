package br.com.uff.vepcm.domain.repository;

import br.com.uff.vepcm.domain.entity.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
    @Query("SELECT s FROM Solicitacao s WHERE s.protocolo LIKE CONCAT('%',:protocolo,'%')")
    List<Solicitacao> buscarSolicitacoesPorProtocolo(@Param("protocolo") String protocolo);

    @Query("SELECT s FROM Solicitacao s WHERE s.idResponsavel = :id")
    List<Solicitacao> buscarSolicitacoesPorResponsavel(Long id);

}
