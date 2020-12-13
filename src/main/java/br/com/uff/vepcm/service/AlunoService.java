package br.com.uff.vepcm.service;

import br.com.uff.vepcm.domain.entity.Aluno;
import javax.validation.Valid;
import java.util.List;

public interface AlunoService {
    Aluno salvarAluno(@Valid Aluno aluno);
    Aluno buscarPorId(Long id);
    List<Aluno> buscarTodosAlunos();
    void removerAluno(Long id);
    List<Aluno> buscaAlunosPorResponsavel(Long id);
    Aluno alterarAluno(Long id, @Valid Aluno aluno);
}
