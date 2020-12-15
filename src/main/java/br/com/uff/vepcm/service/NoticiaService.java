package br.com.uff.vepcm.service;

import br.com.uff.vepcm.domain.entity.Noticia;

import javax.validation.Valid;
import java.util.List;

public interface NoticiaService {

    Noticia salvarNoticia(@Valid Noticia noticia);
    Noticia buscarPorId(Long id);
    List<Noticia> buscarTodasNoticias();
    List<Noticia> buscarNoticiaPorTitulo(String titulo);
    Noticia alterarNoticia(Long id, @Valid Noticia noticia);
    void removerNoticia(Long id);

}

