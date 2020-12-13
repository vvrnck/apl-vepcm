package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.domain.entity.Aluno;
import br.com.uff.vepcm.service.AlunoService;
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
@RequestMapping("aluno")
@Tag(name = "Aluno")
@CrossOrigin
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @Operation(summary = "Cria um novo Aluno.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluno criado com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AlunoDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Aluno inválido.", content = @Content)
    })
    @PostMapping
    public AlunoDTO criarAluno (@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.salvarAluno(mapperUtil.mapTo(alunoDTO, Aluno.class));
        return mapperUtil.mapTo(aluno, AlunoDTO.class);
    }

    @Operation(summary = "Busca por todos os alunos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alunos encontrados",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AlunoDTO.class))) })
    })
    @GetMapping
    public List<AlunoDTO> buscarTodos() {
        return mapperUtil.toList(alunoService.buscarTodosAlunos(), AlunoDTO.class);
    }

    @Operation(summary = "Busca um aluno por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AlunoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado.", content = @Content)
    })
    @GetMapping("{id}")
    public AlunoDTO buscarPorId(@Parameter(description = "id do aluno a ser encontrado.") @PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        if (Objects.isNull(aluno))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.mapTo(aluno, AlunoDTO.class);
    }

    @Operation(summary = "Remove um aluno por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno removido com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String remover(@Parameter(description = "id do aluno a ser removido.") @PathVariable Long id) {
        if (Objects.isNull(alunoService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado.");
        alunoService.removerAluno(id);
        return "Aluno removido com sucesso!";
    }


    @Operation(summary = "Altera um aluno.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno alterado com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AlunoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado.", content = @Content)
    })
    @PutMapping("{id}")
    public AlunoDTO alterarAluno(@Parameter(description = "id do aluno a ser alterado.") @PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.alterarAluno(id, mapperUtil.mapTo(alunoDTO, Aluno.class));
        if (Objects.isNull(aluno))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado.");
        return mapperUtil.mapTo(aluno, AlunoDTO.class);
    }


    @Operation(summary = "Busca todos os alunos de um responsável por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alunos encontrados.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AlunoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Alunos não encontrados.", content = @Content)
    })
    @GetMapping("responsavel/{id}")
    public List<AlunoDTO> buscarAlunosPorId(@Parameter(description = "id do responsável que possui alunos.") @PathVariable Long id) {
        List<Aluno> alunos = alunoService.buscaAlunosPorResponsavel(id);
        if (Objects.isNull(alunos))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return mapperUtil.toList(alunos, AlunoDTO.class);
    }

}

