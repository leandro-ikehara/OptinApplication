package com.example.optin.domain.ports.output;

import com.example.optin.domain.model.Aceite;

/**
 * Porta de Saída (Output Port) para geração de token.
 * Define o contrato que o adaptador de provedor de token deve implementar.
 */
public interface TokenProviderPort {
    String gerarToken(Aceite aceite);
}

