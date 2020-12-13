package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.domain.entity.UnidadeEscolar;
import br.com.uff.vepcm.service.UnidadeEscolarService;
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

    @Operation(summary = "Cria uma nova Unidade Escolar.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Unidade Escolar criada com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UnidadeEscolarDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Unidade Escolar inválida.", content = @Content)
    })
    @PostMapping
    public UnidadeEscolarDTO criarUnidadeEscolar (@RequestBody UnidadeEscolarDTO unidadeEscolarDTO) {
        UnidadeEscolar unidadeEscolar = unidadeEscolarService.salvarUE(mapperUtil.mapTo(unidadeEscolarDTO, UnidadeEscolar.class));
        return mapperUtil.mapTo(unidadeEscolar, UnidadeEscolarDTO.class);
    }

    @Operation(summary = "Busca por todas as Unidades Escolares.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Unidades Escolares encontradas.",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UnidadeEscolarDTO.class))) })
    })
    @GetMapping
    public List<UnidadeEscolarDTO> buscarTodos() {
        return mapperUtil.toList(unidadeEscolarService.buscarTodas(), UnidadeEscolarDTO.class);
    }

    @Operation(summary = "Busca uma Unidade Escolar pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Unidade Escolar encontrada.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UnidadeEscolarDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Unidade Escolar não encontrada.", content = @Content)
    })
    @GetMapping("{id}")
    public UnidadeEscolarDTO buscarPorId(@Parameter(description = "id da Unidade Escolar a ser encontrada.") @PathVariable Long id) {
        UnidadeEscolar unidadeEscolar = unidadeEscolarService.buscarPorId(id);
        if (Objects.isNull(unidadeEscolar))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.mapTo(unidadeEscolar, UnidadeEscolarDTO.class);
    }

    @Operation(summary = "Remove uma Unidade Escolar por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Unidade Escolar removida com sucesso."),
            @ApiResponse(responseCode = "404", description = "Unidade Escolar não encontrada.", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String remover(@Parameter(description = "id da Unidade Escolar a ser removida.") @PathVariable Long id) {
        if (Objects.isNull(unidadeEscolarService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unidade Escolar não encontrada.");
        unidadeEscolarService.removerUE(id);
        return "Unidade Escolar removida com sucesso!";
    }


    @Operation(summary = "Altera uma Unidade Escolar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Unidade Escolar alterada com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UnidadeEscolarDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Unidade Escolar não encontrada.", content = @Content)
    })
    @PutMapping("{id}")
    public UnidadeEscolarDTO alterarUnidadeEscolar(@Parameter(description = "id da Unidade Escolar a ser alterada.") @PathVariable Long id, @RequestBody UnidadeEscolarDTO unidadeEscolarDTO) {
        UnidadeEscolar unidadeEscolar = unidadeEscolarService.alterarUE(id, mapperUtil.mapTo(unidadeEscolarDTO, UnidadeEscolar.class));
        if (Objects.isNull(unidadeEscolar))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unidade Escolar não encontrada.");
        return mapperUtil.mapTo(unidadeEscolar, UnidadeEscolarDTO.class);
    }


}
