package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.domain.entity.Solicitacao;
import br.com.uff.vepcm.service.SolicitacaoService;
import br.com.uff.vepcm.web.dto.SolicitacaoDTO;
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
@RequestMapping("solicitacao")
@Tag(name = "Solicitacao")
@CrossOrigin
public class SolicitacaoController {

    @Autowired
    SolicitacaoService solicitacaoService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @PostMapping
    public SolicitacaoDTO criarSolicitacao (@RequestBody SolicitacaoDTO solicitacaoDTO) {
        Solicitacao solicitacao = solicitacaoService.salvarSolicitacao(mapperUtil.mapTo(solicitacaoDTO, Solicitacao.class));
        return mapperUtil.mapTo(solicitacao, SolicitacaoDTO.class);
    }

    @Operation(summary = "Retorna todas as solicitações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitacões encontradas",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SolicitacaoDTO.class))) })
    })
    @GetMapping
    public List<SolicitacaoDTO> buscarTodos() {
        return mapperUtil.toList(solicitacaoService.buscarTodasSolicitacoes(), SolicitacaoDTO.class);
    }

    @Operation(summary = "Busca uma solicitacao por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitacao encontrada",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Solicitacao nao encontrada", content = @Content)
    })
    @GetMapping("{id}")
    public SolicitacaoDTO buscarPorId(@Parameter(description = "id do solicitacao a ser encontrado") @PathVariable Long id) {
        Solicitacao solicitacao = solicitacaoService.buscarPorId(id);
        if (Objects.isNull(solicitacao))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.mapTo(solicitacao, SolicitacaoDTO.class);
    }

    @Operation(summary = "Remove um solicitacao por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitacao removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Solicitacao nao encontrado", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String remover(@Parameter(description = "id do solicitacao a ser removido") @PathVariable Long id) {
        if (Objects.isNull(solicitacaoService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Solicitacao nao encontrado");
        solicitacaoService.removerSolicitacao(id);
        return "Solicitacao removido com sucesso!";
    }


    @Operation(summary = "Altera uma solicitacao")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitacao alterado com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Solicitacao nao encontrada", content = @Content)
    })
    @PutMapping("{id}")
    public SolicitacaoDTO alterarSolicitacao(@Parameter(description = "id da solicitacao a ser alterada") @PathVariable Long id, @RequestBody SolicitacaoDTO solicitacaoDTO) {
        Solicitacao solicitacao = solicitacaoService.alterarSolicitacao(id, mapperUtil.mapTo(solicitacaoDTO, Solicitacao.class));
        if (Objects.isNull(solicitacao))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Solicitacao nao encontrada");
        return mapperUtil.mapTo(solicitacao, SolicitacaoDTO.class);
    }


    @Operation(summary = "Busca as solicitacaos pelo protocolo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitacoes encontradas",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Solicitacoes nao encontradas", content = @Content)
    })
    @GetMapping("search")
    public List<SolicitacaoDTO> buscarSolicitacoesPorProtocolo(@Parameter(description = "solicitacoes que possuem esse numero de protocolo") @RequestParam(name = "protocolo") String protocolo) {
        List<Solicitacao> solicitacaos = solicitacaoService.buscarSolicitacoesPorProtocolo(protocolo);
        if (Objects.isNull(solicitacaos))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.toList(solicitacaos, SolicitacaoDTO.class);
    }

}

