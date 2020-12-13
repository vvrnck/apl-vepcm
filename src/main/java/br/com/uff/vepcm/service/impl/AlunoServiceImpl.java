package br.com.uff.vepcm.service.impl;

import br.com.uff.vepcm.domain.entity.Aluno;
import br.com.uff.vepcm.domain.repository.AlunoRepository;
import br.com.uff.vepcm.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Transactional
    @Override
    public Aluno salvarAluno(@Valid Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> buscarTodosAlunos() { return alunoRepository.findAll(); };

    @Override
    public void removerAluno(Long id) { alunoRepository.deleteById(id); };

    @Override
    public Aluno buscarPorId(Long id) { return alunoRepository.findById(id).orElse(null); };

    @Override
    public List<Aluno> buscaAlunosPorResponsavel(Long id) {
        return alunoRepository.buscaAlunosPorResponsavel(id);
    }

    @Transactional
    @Override
    public Aluno alterarAluno(Long id, @Valid Aluno alunoAlterado) {
        Aluno aluno = buscarPorId(id);

        if (Objects.isNull(aluno)) return null;

        if (Objects.nonNull(alunoAlterado.getIdResponsavel())) aluno.setIdResponsavel(alunoAlterado.getIdResponsavel());
        if (Objects.nonNull(alunoAlterado.getPessoa())) aluno.setPessoa(alunoAlterado.getPessoa());
        if (Objects.nonNull(alunoAlterado.getNaturalidade())) aluno.setNaturalidade(alunoAlterado.getNaturalidade());
        if (Objects.nonNull(alunoAlterado.getNomeMae())) aluno.setNomeMae(alunoAlterado.getNomeMae());
        if (Objects.nonNull(alunoAlterado.getNomePai())) aluno.setNomePai(alunoAlterado.getNomePai());
        return salvarAluno(aluno);
    }
}
