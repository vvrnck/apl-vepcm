package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.domain.entity.AnoEscolaridade;
import br.com.uff.vepcm.service.AnoEscolaridadeService;
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

    @Operation(summary = "Cria um novo Ano Escolaridade.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ano Escolaridade criado com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AnoEscolaridadeDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Ano Escolaridade inválido.", content = @Content)
    })
    @PostMapping
    public AnoEscolaridadeDTO criarAnoEscolaridade (@RequestBody AnoEscolaridadeDTO anoEscolaridadeDTO) {
        AnoEscolaridade anoEscolaridade = anoEscolaridadeService.salvarAnoEscolaridade(mapperUtil.mapTo(anoEscolaridadeDTO, AnoEscolaridade.class));
        return mapperUtil.mapTo(anoEscolaridade, AnoEscolaridadeDTO.class);
    }

    @Operation(summary = "Busca por todos os Anos Escolaridades.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anos Escolaridades encontrados.",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AnoEscolaridadeDTO.class))) })
    })
    @GetMapping
    public List<AnoEscolaridadeDTO> buscarTodos() {
        return mapperUtil.toList(anoEscolaridadeService.buscarTodos(), AnoEscolaridadeDTO.class);
    }

    @Operation(summary = "Busca um Ano Escolaridade por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ano Escolaridade encontrado.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AnoEscolaridadeDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Ano Escolaridade não encontrado.", content = @Content)
    })
    @GetMapping("{id}")
    public AnoEscolaridadeDTO buscarPorId(@Parameter(description = "id do Ano Escolaridade a ser encontrado.") @PathVariable Long id) {
        AnoEscolaridade anoEscolaridade = anoEscolaridadeService.buscarPorId(id);
        if (Objects.isNull(anoEscolaridade))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.mapTo(anoEscolaridade, AnoEscolaridadeDTO.class);
    }


    @Operation(summary = "Altera um Ano Escolaridade.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ano Escolaridade alterado com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AnoEscolaridadeDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Ano Escolaridade não encontrado.", content = @Content)
    })
    @PutMapping("{id}")
    public AnoEscolaridadeDTO alterarAnoEscolaridade(@Parameter(description = "id do Ano Escolaridade a ser alterado.") @PathVariable Long id, @RequestBody AnoEscolaridadeDTO anoEscolaridadeDTO) {
        AnoEscolaridade ae = anoEscolaridadeService.alterarAnoEscolaridade(id, mapperUtil.mapTo(anoEscolaridadeDTO, AnoEscolaridade.class));
        if (Objects.isNull(ae))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ano Escolaridade não encontrado.");
        return mapperUtil.mapTo(ae, AnoEscolaridadeDTO.class);
    }


    @Operation(summary = "Remove um Ano Escolaridade por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ano Escolaridade removido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ano Escolaridade não encontrado.", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String remover(@Parameter(description = "id do Ano Escolaridade a ser removido.") @PathVariable Long id) {
        if (Objects.isNull(anoEscolaridadeService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ano Escolaridade não encontrado.");
        anoEscolaridadeService.removerAnoEscolaridade(id);
        return "Ano Escolaridade removido com sucesso!";
    }
}
