package br.com.uff.vepcm.domain.repository;

import br.com.uff.vepcm.domain.entity.UnidadeEscolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeEscolarRepository extends JpaRepository<UnidadeEscolar, Long> {
}
