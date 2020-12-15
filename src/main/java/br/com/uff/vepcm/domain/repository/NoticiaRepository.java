package br.com.uff.vepcm.domain.repository;

import br.com.uff.vepcm.domain.entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    @Query("SELECT n FROM Noticia n WHERE n.titulo LIKE CONCAT('%',:titulo,'%')")
    List<Noticia> buscarNoticiaPorTitulo(@Param("titulo") String titulo);

}