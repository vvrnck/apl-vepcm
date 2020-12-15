package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.domain.entity.Noticia;
import br.com.uff.vepcm.service.NoticiaService;
import br.com.uff.vepcm.web.dto.NoticiaDTO;
import br.com.uff.vepcm.web.utils.MapperUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
@RestController
@RequestMapping("noticia")
@Tag(name = "Noticia")
@CrossOrigin
public class NoticiaController {

    @Autowired
    NoticiaService noticiaService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @Operation(summary = "Cria uma nova Notícia.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Notícia criada com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = NoticiaDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Notícia inválida.", content = @Content)
    })
    @PostMapping
    public NoticiaDTO criarNoticia (@RequestBody NoticiaDTO noticiaDTO) {
        Noticia noticia = noticiaService.salvarNoticia(mapperUtil.mapTo(noticiaDTO, Noticia.class));
        return mapperUtil.mapTo(noticia, NoticiaDTO.class);
    }

    @Operation(summary = "Busca por todas as Notícias.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notícias encontradas.",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = NoticiaDTO.class))) })
    })
    @GetMapping
    public List<NoticiaDTO> buscarTodos() {
        return mapperUtil.toList(noticiaService.buscarTodasNoticias(), NoticiaDTO.class);
    }

    @Operation(summary = "Busca uma Notícia por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notícia encontrada.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = NoticiaDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Notícia não encontrada.", content = @Content)
    })
    @GetMapping("{id}")
    public NoticiaDTO buscarPorId(@Parameter(description = "id da Notícia a ser encontrada.") @PathVariable Long id) {
        Noticia noticia = noticiaService.buscarPorId(id);
        if (Objects.isNull(noticia))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.mapTo(noticia, NoticiaDTO.class);
    }

    @Operation(summary = "Remove uma Notícia por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notícia removida com sucesso."),
            @ApiResponse(responseCode = "404", description = "Notícia não encontrada.", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String remover(@Parameter(description = "id da Notícia a ser removida.") @PathVariable Long id) {
        if (Objects.isNull(noticiaService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notícia não encontrada.");
        noticiaService.removerNoticia(id);
        return "Notícia removida com sucesso!";
    }


    @Operation(summary = "Altera uma Notícia.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notícia alterada com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = NoticiaDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Notícia não encontrada.", content = @Content)
    })
    @PutMapping("{id}")
    public NoticiaDTO alterarNoticia(@Parameter(description = "id da Notícia a ser alterada.") @PathVariable Long id, @RequestBody NoticiaDTO noticiaDTO) {
        Noticia noticia = noticiaService.alterarNoticia(id, mapperUtil.mapTo(noticiaDTO, Noticia.class));
        if (Objects.isNull(noticia))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notícia não encontrada.");
        return mapperUtil.mapTo(noticia, NoticiaDTO.class);
    }


    @Operation(summary = "Busca a Notícia pelo título.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notícia encontrada.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = NoticiaDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Notícia não encontrada.", content = @Content)
    })
    @GetMapping("search")
    public List<NoticiaDTO> buscarNoticiaPorTitulo(@Parameter(description = "título de uma Notícia.") @RequestParam(name = "titulo") String titulo) {
        List<Noticia> noticias = noticiaService.buscarNoticiaPorTitulo(titulo);
        if (Objects.isNull(noticias))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.toList(noticias, NoticiaDTO.class);
    }

}
