package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.domain.entity.Usuario;
import br.com.uff.vepcm.service.UsuarioService;
import br.com.uff.vepcm.web.dto.UsuarioDTO;
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
@RequestMapping("usuario")
@Tag(name = "Usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    MapperUtil mapperUtil = MapperUtil.getInstance();

    @Operation(summary = "Busca por todos os usuários.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários encontrados",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UsuarioDTO.class))) })
    })
    @GetMapping
    public List<UsuarioDTO> buscarTodos() {
        return mapperUtil.toList(usuarioService.buscarTodosUsuarios(), UsuarioDTO.class);
    }

    @Operation(summary = "Cria um novo usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Usuário inválido.", content = @Content)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = mapperUtil.mapTo(usuarioDTO, Usuario.class);
        return mapperUtil.mapTo(usuarioService.salvarUsuario(usuario), UsuarioDTO.class);
    }

    @Operation(summary = "Busca um usuário por seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado.", content = @Content)
    })
    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@Parameter(description = "id do usuário a ser buscado.") @PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (Objects.isNull(usuario))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        return mapperUtil.mapTo(usuario, UsuarioDTO.class);
    }

    @Operation(summary = "Altera um usuário existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado.", content = @Content)
    })
    @PutMapping("{id}")
    public UsuarioDTO alterarUsuario(@Parameter(description = "id do usuário a ser alterado.") @PathVariable Long id,
                                     @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.alterarUsuario(id, mapperUtil.mapTo(usuarioDTO, Usuario.class));
        if (Objects.isNull(usuario))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        return mapperUtil.mapTo(usuario, UsuarioDTO.class);
    }

    @Operation(summary = "Remove um usuário porr seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário removido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado.", content = @Content)
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String remover(@Parameter(description = "id do usuário a ser removido.") @PathVariable Long id) {
        if (Objects.isNull(usuarioService.buscarPorId(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário nao encontrado.");
        usuarioService.removerUsuario(id);
        return "Usuário removido com Sucesso!";
    }
}
