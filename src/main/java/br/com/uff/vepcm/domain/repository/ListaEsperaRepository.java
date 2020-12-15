package br.com.uff.vepcm.domain.repository;

import br.com.uff.vepcm.domain.entity.ListaEspera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaEsperaRepository extends JpaRepository<ListaEspera, Long> {
    @Query("SELECT le FROM ListaEspera le WHERE le.data LIKE CONCAT('%',:data,'%')")
    List<ListaEspera> buscarListasEsperaPorData(@Param("data") String data);

}
