package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.domain.entity.ListaEspera;
import br.com.uff.vepcm.service.ListaEsperaService;
import br.com.uff.vepcm.web.dto.ListaEsperaDTO;
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
    @RequestMapping("le")
    @Tag(name = "ListaEspera")
    @CrossOrigin
    public class ListaEsperaController {

        @Autowired
        ListaEsperaService listaEsperaService;

        MapperUtil mapperUtil = MapperUtil.getInstance();

        @Operation(summary = "Cria uma nova Lista de Espera.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Lista de Espera criada com sucesso.",
                        content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ListaEsperaDTO.class)) }),
                @ApiResponse(responseCode = "400", description = "Lista de Espera inválida.", content = @Content)
        })
        @PostMapping
        public ListaEsperaDTO criarListaEspera (@RequestBody ListaEsperaDTO listaEsperaDTO) {
            ListaEspera listaEspera = listaEsperaService.salvarListaEspera(mapperUtil.mapTo(listaEsperaDTO, ListaEspera.class));
            return mapperUtil.mapTo(listaEspera, ListaEsperaDTO.class);
        }

        @Operation(summary = "Busca por todas as Listas de Espera.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Listas de Espera encontradas.",
                        content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ListaEsperaDTO.class))) })
        })
        @GetMapping
        public List<ListaEsperaDTO> buscarTodos() {
            return mapperUtil.toList(listaEsperaService.buscarTodasListasEspera(), ListaEsperaDTO.class);
        }

        @Operation(summary = "Busca uma Lista de Espera por seu id.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Lista de Espera encontrada.",
                        content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ListaEsperaDTO.class)) }),
                @ApiResponse(responseCode = "404", description = "Lista de Espera não encontrada.", content = @Content)
        })
        @GetMapping("{id}")
        public ListaEsperaDTO buscarPorId(@Parameter(description = "id da Lista de Espera a ser encontrada.") @PathVariable Long id) {
            ListaEspera listaEspera = listaEsperaService.buscarPorId(id);
            if (Objects.isNull(listaEspera))
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return mapperUtil.mapTo(listaEspera, ListaEsperaDTO.class);
        }

        @Operation(summary = "Remove uma Lista de Espera por seu id.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Lista de Espera removida com sucesso."),
                @ApiResponse(responseCode = "404", description = "Lista de Espera não encontrada.", content = @Content)
        })
        @DeleteMapping("{id}")
        @ResponseStatus(HttpStatus.OK)
        public String remover(@Parameter(description = "id da Lista de Espera a ser removida.") @PathVariable Long id) {
            if (Objects.isNull(listaEsperaService.buscarPorId(id)))
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista de Espera não encontrada.");
            listaEsperaService.removerListaEspera(id);
            return "Lista de Espera removida com sucesso!";
        }


        @Operation(summary = "Altera uma Lista de Espera.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Lista de Espera alterada com sucesso.",
                        content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ListaEsperaDTO.class)) }),
                @ApiResponse(responseCode = "404", description = "Lista de Espera não encontrada.", content = @Content)
        })
        @PutMapping("{id}")
        public ListaEsperaDTO alterarListaEspera(@Parameter(description = "id da Lista de Espera a ser alterada.") @PathVariable Long id, @RequestBody ListaEsperaDTO listaEsperaDTO) {
            ListaEspera listaEspera = listaEsperaService.alterarListaEspera(id, mapperUtil.mapTo(listaEsperaDTO, ListaEspera.class));
            if (Objects.isNull(listaEspera))
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista de Espera não encontrada.");
            return mapperUtil.mapTo(listaEspera, ListaEsperaDTO.class);
        }


        @Operation(summary = "Busca a Lista de Espera pela data.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Lista de Espera encontrada.",
                        content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ListaEsperaDTO.class)) }),
                @ApiResponse(responseCode = "404", description = "Lista de Espera não encontrada.", content = @Content)
        })
        @GetMapping("search")
        public List<ListaEsperaDTO> buscarListasEsperaPorData(@Parameter(description = "data de uma Lista de Espera.") @RequestParam(name = "data") String data) {
            List<ListaEspera> listasEspera = listaEsperaService.buscarListasEsperaPorData(data);
            if (Objects.isNull(listasEspera))
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return mapperUtil.toList(listasEspera, ListaEsperaDTO.class);
        }

}
