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

    @Operation(summary = "Cria uma nova Solicitação.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Solicitação criada com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida.", content = @Content)
    })
    @PostMapping
    public SolicitacaoDTO criarSolicitacao (@RequestBody SolicitacaoDTO solicitacaoDTO) {
        Solicitacao solicitacao = solicitacaoService.salvarSolicitacao(mapperUtil.mapTo(solicitacaoDTO, Solicitacao.class));
        return mapperUtil.mapTo(solicitacao, SolicitacaoDTO.class);
    }

    @Operation(summary = "Busca por todas as Solicitações.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitações encontradas.",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SolicitacaoDTO.class))) })
    })
    @GetMapping
    public List<SolicitacaoDTO> buscarTodos() {
        return mapperUtil.toList(solicitacaoService.buscarTodasSolicitacoes(), SolicitacaoDTO.class);
    }

    @Operation(summary = "Busca uma Solicitação por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitação encontrada.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Solicitação não encontrada.", content = @Content)
    })
    @GetMapping("{id}")
    public SolicitacaoDTO buscarPorId(@Parameter(description = "id da Solicitação a ser encontrada.") @PathVariable Long id) {
        Solicitacao solicitacao = solicitacaoService.buscarPorId(id);
        if (Objects.isNull(solicitacao))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.mapTo(solicitacao, SolicitacaoDTO.class);
    }

    @Operation(summary = "Remove uma Solicitação por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitação removida com sucesso."),
            @ApiResponse(responseCode = "404", description = "Solicitação não encontrada.", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String remover(@Parameter(description = "id da Solicitação a ser removida.") @PathVariable Long id) {
        if (Objects.isNull(solicitacaoService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Solicitação não encontrada.");
        solicitacaoService.removerSolicitacao(id);
        return "Solicitação removida com sucesso!";
    }


    @Operation(summary = "Altera uma Solicitação.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitação alterada com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Solicitação não encontrada.", content = @Content)
    })
    @PutMapping("{id}")
    public SolicitacaoDTO alterarSolicitacao(@Parameter(description = "id da Solicitação a ser alterada.") @PathVariable Long id, @RequestBody SolicitacaoDTO solicitacaoDTO) {
        Solicitacao solicitacao = solicitacaoService.alterarSolicitacao(id, mapperUtil.mapTo(solicitacaoDTO, Solicitacao.class));
        if (Objects.isNull(solicitacao))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Solicitação não encontrada.");
        return mapperUtil.mapTo(solicitacao, SolicitacaoDTO.class);
    }


    @Operation(summary = "Busca a Solicitação pelo número do protocolo.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitação encontrada.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Solicitação não encontrada.", content = @Content)
    })
    @CrossOrigin
    @GetMapping("search")
    public List<SolicitacaoDTO> buscarSolicitacoesPorProtocolo(@Parameter(description = "número do protocolo de uma Solicitação.") @RequestParam(name = "protocolo") String protocolo) {
        List<Solicitacao> solicitacaos = solicitacaoService.buscarSolicitacoesPorProtocolo(protocolo);
        if (Objects.isNull(solicitacaos))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.toList(solicitacaos, SolicitacaoDTO.class);
    }

    @Operation(summary = "Busca todos as Solicitações criadas por um responsável dado seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitações encontradas.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Solicitações não encontradas.", content = @Content)
    })
    @GetMapping("responsavel/{id}")
    public List<SolicitacaoDTO> buscarSolicitacoesPorResponsavel(@Parameter(description = "id do responsável que possui Solicitações.") @PathVariable Long id) {
        List<Solicitacao> solicitacoes = solicitacaoService.buscarSolicitacoesPorResponsavel(id);
        if (Objects.isNull(solicitacoes))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.toList(solicitacoes, SolicitacaoDTO.class);
    }

}

