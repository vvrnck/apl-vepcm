package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.domain.entity.FaleConosco;
import br.com.uff.vepcm.service.FaleConoscoService;
import br.com.uff.vepcm.web.dto.FaleConoscoDTO;
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
@RequestMapping("fc")
@Tag(name = "FaleConosco")
@CrossOrigin
public class FaleConoscoController {

    @Autowired
    FaleConoscoService faleConoscoService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @Operation(summary = "Cria um novo Fale Conosco.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fale Conosco criado com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FaleConoscoDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Fale Conosco inválido.", content = @Content)
    })
    @PostMapping
    public FaleConoscoDTO criarFaleConosco (@RequestBody FaleConoscoDTO faleConoscoDTO) {
        FaleConosco faleConosco = faleConoscoService.salvarFaleConosco(mapperUtil.mapTo(faleConoscoDTO, FaleConosco.class));
        return mapperUtil.mapTo(faleConosco, FaleConoscoDTO.class);
    }

    @Operation(summary = "Busca por todos os Fale Conosco.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fale Conosco encontrados.",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FaleConoscoDTO.class))) })
    })
    @GetMapping
    public List<FaleConoscoDTO> buscarTodos() {
        return mapperUtil.toList(faleConoscoService.buscarTodosFaleConosco(), FaleConoscoDTO.class);
    }

    @Operation(summary = "Busca um Fale Conosco por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fale Conosco encontrado.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FaleConoscoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Fale Conosco não encontrado.", content = @Content)
    })
    @GetMapping("{id}")
    public FaleConoscoDTO buscarPorId(@Parameter(description = "id do Fale Conosco a ser encontrado.") @PathVariable Long id) {
        FaleConosco faleConosco = faleConoscoService.buscarPorId(id);
        if (Objects.isNull(faleConosco))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.mapTo(faleConosco, FaleConoscoDTO.class);
    }

    @Operation(summary = "Remove um Fale Conosco por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fale Conosco removido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Fale Conosco não encontrado.", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String remover(@Parameter(description = "id do Fale Conosco a ser removido.") @PathVariable Long id) {
        if (Objects.isNull(faleConoscoService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fale Conosco não encontrado.");
        faleConoscoService.removerFaleConosco(id);
        return "Fale Conosco removido com sucesso!";
    }


    @Operation(summary = "Altera um Fale Conosco.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fale Conosco alterado com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FaleConoscoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Fale Conosco não encontrado.", content = @Content)
    })
    @PutMapping("{id}")
    public FaleConoscoDTO alterarFaleConosco(@Parameter(description = "id do Fale Conosco a ser alterado.") @PathVariable Long id, @RequestBody FaleConoscoDTO faleConoscoDTO) {
        FaleConosco faleConosco = faleConoscoService.alterarFaleConosco(id, mapperUtil.mapTo(faleConoscoDTO, FaleConosco.class));
        if (Objects.isNull(faleConosco))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fale Conosco não encontrado.");
        return mapperUtil.mapTo(faleConosco, FaleConoscoDTO.class);
    }

    @Operation(summary = "Busca o Fale Conosco pelo Assunto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fale Conosco encontrado.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FaleConoscoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Fale Conosco não encontrado.", content = @Content)
    })
    @GetMapping("search")
    public List<FaleConoscoDTO> buscarFaleConoscoPorAssunto(@Parameter(description = "assunto de um Fale Conosco.") @RequestParam(name = "assunto") String assunto) {
        List<FaleConosco> faleconosco = faleConoscoService.buscarFaleConoscoPorAssunto(assunto);
        if (Objects.isNull(faleconosco))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.toList(faleconosco, FaleConoscoDTO.class);
    }

}


