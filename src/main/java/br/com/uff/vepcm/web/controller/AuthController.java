package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.domain.entity.Usuario;
import br.com.uff.vepcm.service.AuthService;
import br.com.uff.vepcm.service.exception.LoginUsuarioException;
import br.com.uff.vepcm.web.dto.AlunoDTO;
import br.com.uff.vepcm.web.dto.UsuarioDTO;
import br.com.uff.vepcm.web.utils.MapperUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("auth")
@Tag(name = "auth")
@CrossOrigin
public class AuthController {

    @Autowired
    AuthService authService;

    MapperUtil mapperUtil = MapperUtil.getInstance();


    @Operation(summary = "Realiza o login de um usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Realiza o login através do email e senha do usuário.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class)) }),
            @ApiResponse(responseCode = "403", description = "Usuário inválido e/ou sem autorização.", content = @Content)
    })
    @PostMapping("login")
    public UsuarioDTO login (@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = authService.login(mapperUtil.mapTo(usuarioDTO, Usuario.class));
            return mapperUtil.mapTo(usuario, UsuarioDTO.class);
        } catch (LoginUsuarioException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
