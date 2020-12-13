package br.com.uff.vepcm.web.controller;


import br.com.uff.vepcm.domain.entity.Aluno;
import br.com.uff.vepcm.domain.entity.AnoEscolaridade;
import br.com.uff.vepcm.service.AnoEscolaridadeService;
import br.com.uff.vepcm.web.dto.AlunoDTO;
import br.com.uff.vepcm.web.dto.AnoEscolaridadeDTO;
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
@RequestMapping("ae")
@Tag(name = "AnoEscolaridade")
@CrossOrigin
public class AnoEscolaridadeController {
    @Autowired
    AnoEscolaridadeService anoEscolaridadeService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @PostMapping
    public AnoEscolaridadeDTO criarAnoEscolaridade (@RequestBody AnoEscolaridadeDTO anoEscolaridadeDTO) {
        AnoEscolaridade anoEscolaridade = anoEscolaridadeService.salvarAnoEscolaridade(mapperUtil.mapTo(anoEscolaridadeDTO, AnoEscolaridade.class));
        return mapperUtil.mapTo(anoEscolaridade, AnoEscolaridadeDTO.class);
    }

    @Operation(summary = "Retorna todos os anoEscolaridades")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "AnoEscolaridades encontrados",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AnoEscolaridadeDTO.class))) })
    })
    @GetMapping
    public List<AnoEscolaridadeDTO> buscarTodos() {
        return mapperUtil.toList(anoEscolaridadeService.buscarTodos(), AnoEscolaridadeDTO.class);
    }

    @Operation(summary = "Busca um anoEscolaridade por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "AnoEscolaridade encontrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AnoEscolaridadeDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "AnoEscolaridade nao encontrado", content = @Content)
    })
    @GetMapping("{id}")
    public AnoEscolaridadeDTO buscarPorId(@Parameter(description = "id do anoEscolaridade a ser encontrado") @PathVariable Long id) {
        AnoEscolaridade anoEscolaridade = anoEscolaridadeService.buscarPorId(id);
        if (Objects.isNull(anoEscolaridade))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.mapTo(anoEscolaridade, AnoEscolaridadeDTO.class);
    }


    @Operation(summary = "Altera um ano escolaridade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ano escolaridade alterado com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AnoEscolaridadeDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Ano escolaridade nao encontrado", content = @Content)
    })
    @PutMapping("{id}")
    public AnoEscolaridadeDTO alterarAnoEscolaridade(@Parameter(description = "id do AE a ser alterado") @PathVariable Long id, @RequestBody AnoEscolaridadeDTO anoEscolaridadeDTO) {
        AnoEscolaridade ae = anoEscolaridadeService.alterarAnoEscolaridade(id, mapperUtil.mapTo(anoEscolaridadeDTO, AnoEscolaridade.class));
        if (Objects.isNull(ae))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AE nao encontrado");
        return mapperUtil.mapTo(ae, AnoEscolaridadeDTO.class);
    }


    @Operation(summary = "Remove um anoEscolaridade por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "AnoEscolaridade removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "AnoEscolaridade nao encontrado", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String remover(@Parameter(description = "id do anoEscolaridade a ser removido") @PathVariable Long id) {
        if (Objects.isNull(anoEscolaridadeService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AnoEscolaridade nao encontrado");
        anoEscolaridadeService.removerAnoEscolaridade(id);
        return "AnoEscolaridade removido com sucesso!";
    }
}
