package com.example.optin.infraestructure.adapter.output.security;

import com.example.optin.domain.model.Aceite;
import com.example.optin.domain.ports.output.TokenProviderPort;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.UUID;

/**
 * Adaptador de Saída (Driven Adapter) para geração de token.
 * Implementa a porta de provedor de token.
 */
@Component
public class TokenProviderAdapter implements TokenProviderPort {

    @Override
    public String gerarToken(Aceite aceite) {
        // Lógica para gerar um token. Pode ser um JWT, um UUID, ou outro formato.
        // Para este exemplo, criaremos um token simples combinando UUID e ID do usuário.
        String tokenPayload = aceite.getIdUsuario() + ":" + UUID.randomUUID().toString();
        return Base64.getEncoder().encodeToString(tokenPayload.getBytes());
    }
}
