package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.domain.entity.Aluno;
import br.com.uff.vepcm.domain.entity.UnidadeEscolar;
import br.com.uff.vepcm.service.UnidadeEscolarService;
import br.com.uff.vepcm.web.dto.AlunoDTO;
import br.com.uff.vepcm.web.dto.UnidadeEscolarDTO;
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
@RequestMapping("ue")
@Tag(name = "UnidadeEscolar")
@CrossOrigin
public class UnidadeEscolarController {
    @Autowired
    UnidadeEscolarService unidadeEscolarService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @PostMapping
    public UnidadeEscolarDTO criarUnidadeEscolar (@RequestBody UnidadeEscolarDTO unidadeEscolarDTO) {
        UnidadeEscolar unidadeEscolar = unidadeEscolarService.salvarUE(mapperUtil.mapTo(unidadeEscolarDTO, UnidadeEscolar.class));
        return mapperUtil.mapTo(unidadeEscolar, UnidadeEscolarDTO.class);
    }

    @Operation(summary = "Retorna todos os unidadeEscolars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UnidadeEscolars encontrados",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UnidadeEscolarDTO.class))) })
    })
    @GetMapping
    public List<UnidadeEscolarDTO> buscarTodos() {
        return mapperUtil.toList(unidadeEscolarService.buscarTodas(), UnidadeEscolarDTO.class);
    }

    @Operation(summary = "Busca um unidadeEscolar por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UnidadeEscolar encontrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UnidadeEscolarDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "UnidadeEscolar nao encontrado", content = @Content)
    })
    @GetMapping("{id}")
    public UnidadeEscolarDTO buscarPorId(@Parameter(description = "id do unidadeEscolar a ser encontrado") @PathVariable Long id) {
        UnidadeEscolar unidadeEscolar = unidadeEscolarService.buscarPorId(id);
        if (Objects.isNull(unidadeEscolar))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.mapTo(unidadeEscolar, UnidadeEscolarDTO.class);
    }

    @Operation(summary = "Remove um unidadeEscolar por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UnidadeEscolar removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "UnidadeEscolar nao encontrado", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String remover(@Parameter(description = "id do unidadeEscolar a ser removido") @PathVariable Long id) {
        if (Objects.isNull(unidadeEscolarService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UnidadeEscolar nao encontrado");
        unidadeEscolarService.removerUE(id);
        return "UnidadeEscolar removido com sucesso!";
    }


    @Operation(summary = "Altera um unidadeEscolar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UnidadeEscolar alterado com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UnidadeEscolarDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "UnidadeEscolar nao encontrado", content = @Content)
    })
    @PutMapping("{id}")
    public UnidadeEscolarDTO alterarUnidadeEscolar(@Parameter(description = "id do unidadeEscolar a ser alterado") @PathVariable Long id, @RequestBody UnidadeEscolarDTO unidadeEscolarDTO) {
        UnidadeEscolar unidadeEscolar = unidadeEscolarService.alterarUE(id, mapperUtil.mapTo(unidadeEscolarDTO, UnidadeEscolar.class));
        if (Objects.isNull(unidadeEscolar))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UnidadeEscolar nao encontrado");
        return mapperUtil.mapTo(unidadeEscolar, UnidadeEscolarDTO.class);
    }

}
