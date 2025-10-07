package com.example.optin.OptinApplication.service;

import com.example.optin.domain.model.Aceite;
import com.example.optin.domain.ports.input.ProcessarAceite;
import com.example.optin.domain.ports.output.AceiteRepositoryPort;
import com.example.optin.domain.ports.output.TokenProviderPort;

/**
 * Camada de Aplicação/Serviço.
 * Implementa o caso de uso (porta de entrada) e orquestra as portas de saída.
 * Esta é a classe que contém a lógica de negócio principal.
 */
public class AceiteService implements ProcessarAceite {

    private final AceiteRepositoryPort aceiteRepositoryPort;
    private final TokenProviderPort tokenProviderPort;

    public AceiteService(AceiteRepositoryPort aceiteRepositoryPort, TokenProviderPort tokenProviderPort) {
        this.aceiteRepositoryPort = aceiteRepositoryPort;
        this.tokenProviderPort = tokenProviderPort;
    }

    @Override
    public String executar(Aceite aceite) {
        // 1. Salva o aceite utilizando a porta de persistência
        aceiteRepositoryPort.salvar(aceite);

        // 2. Gera o token de autorização utilizando a porta do provedor de token
        return tokenProviderPort.gerarToken(aceite);
    }
}