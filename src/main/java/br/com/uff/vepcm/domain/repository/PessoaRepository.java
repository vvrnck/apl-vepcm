package br.com.uff.vepcm.domain.repository;

import br.com.uff.vepcm.domain.entity.Pessoa;
import br.com.uff.vepcm.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
