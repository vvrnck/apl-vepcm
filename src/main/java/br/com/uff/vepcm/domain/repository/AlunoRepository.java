package br.com.uff.vepcm.domain.repository;

import br.com.uff.vepcm.domain.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Query("SELECT a FROM Aluno a WHERE a.idResponsavel = :id")
    List<Aluno> buscaAlunosPorResponsavel(Long id);
}
