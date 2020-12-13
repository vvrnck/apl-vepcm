package br.com.uff.vepcm.web.controller;

import br.com.uff.vepcm.web.dto.AlunoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;
import java.util.Collections;
import java.util.Map;

@RestController
public class Health {

    @Operation(summary = "Retorna o status da API.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o status da API, serve como um health check.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))  })
    })
    @GetMapping("health")
    @ResponseBody
    public Map<String, String> health() {
        return Collections.singletonMap("message", "up!");
    }
    
}
