package br.com.uff.vepcm.domain.repository;

import br.com.uff.vepcm.domain.entity.AnoEscolaridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnoEscolaridadeRepository extends JpaRepository<AnoEscolaridade, Long> {
}
