package br.com.uff.vepcm.domain.repository;

import br.com.uff.vepcm.domain.entity.FaleConosco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaleConoscoRepository extends JpaRepository<FaleConosco, Long> {

    @Query("SELECT fc FROM FaleConosco fc WHERE fc.assunto LIKE CONCAT('%',:assunto,'%')")
    List<FaleConosco> buscarFaleConoscoPorAssunto(@Param("assunto") String assunto);

}
