package com.example.optin.infraestructure.adapter.input;

import com.example.optin.domain.model.Aceite;
import com.example.optin.domain.ports.input.ProcessarAceite;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Adaptador de Entrada (Driving Adapter).
 * Expõe a funcionalidade da aplicação através de uma API REST.
 * Ele traduz o DTO HTTP para o modelo de domínio e chama o caso de uso.
 */
@RestController
@RequestMapping("/api/v1/optin")
public class AceiteController {

    private final ProcessarAceite processarAceiteUseCase;

    public AceiteController(ProcessarAceite processarAceiteUseCase) {
        this.processarAceiteUseCase = processarAceiteUseCase;
    }

    @PostMapping("/aceite")
    public ResponseEntity<TokenResponse> registrarAceite(@RequestBody AceiteRequest request) {
        try {
            // Converte o DTO de requisição para o modelo de domínio
            Aceite aceite = new Aceite(request.getIdUsuario(), request.isConsentimento(), request.getCanal());

            // Executa o caso de uso
            String token = processarAceiteUseCase.executar(aceite);

            // Retorna o DTO de resposta
            return ResponseEntity.ok(new TokenResponse(token));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * DTO (Data Transfer Object) para a requisição.
     */
    @Data
    static class AceiteRequest {
        private String idUsuario;
        private boolean consentimento;
        private String canal;
        // Métodos para compatibilidade com o uso no controller
        public String getIdUsuario() { return idUsuario; }
        public boolean isConsentimento() { return consentimento; }
        public String getCanal() { return canal; }
    }

    /**
     * DTO para a resposta.
     */
    @Data
    static class TokenResponse {
        private String tokenAutorizacao;
        public TokenResponse(String tokenAutorizacao) {
            this.tokenAutorizacao = tokenAutorizacao;
        }
        public TokenResponse() {}
    }
}
