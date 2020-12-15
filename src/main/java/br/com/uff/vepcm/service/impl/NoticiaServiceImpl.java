
package br.com.uff.vepcm.service.impl;

import br.com.uff.vepcm.domain.entity.*;
import br.com.uff.vepcm.domain.repository.NoticiaRepository;
import br.com.uff.vepcm.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Service
public class NoticiaServiceImpl implements NoticiaService {

    @Autowired
    NoticiaRepository noticiaRepository;

    @Transactional
    @Override
    public Noticia salvarNoticia(@Valid Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    @Override
    public List<Noticia> buscarTodasNoticias() { return noticiaRepository.findAll(); };

    @Override
    public void removerNoticia(Long id) { noticiaRepository.deleteById(id); };

    @Override
    public Noticia buscarPorId(Long id) { return noticiaRepository.findById(id).orElse(null); };

    @Override
    public List<Noticia> buscarNoticiaPorTitulo(String titulo) {
        return noticiaRepository.buscarNoticiaPorTitulo(titulo);
    }

    @Transactional
    @Override
    public Noticia alterarNoticia(Long id, @Valid Noticia noticiaAlterado) {
        Noticia noticia = buscarPorId(id);

        if (Objects.isNull(noticia)) return null;

        if (Objects.nonNull(noticiaAlterado.getId())) noticia.setId(noticiaAlterado.getId());
        if (Objects.nonNull(noticiaAlterado.getAno())) noticia.setAno(noticiaAlterado.getAno());
        if (Objects.nonNull(noticiaAlterado.getConteudo())) noticia.setConteudo(noticiaAlterado.getConteudo());
        if (Objects.nonNull(noticiaAlterado.getTitulo())) noticia.setTitulo(noticiaAlterado.getTitulo());
        if (Objects.nonNull(noticiaAlterado.getAutor())) noticia.setAutor(noticiaAlterado.getAutor());
        if (Objects.nonNull(noticiaAlterado.getIdFuncionario())) noticia.setIdFuncionario(noticiaAlterado.getIdFuncionario());
        return salvarNoticia(noticia);
    }

}



