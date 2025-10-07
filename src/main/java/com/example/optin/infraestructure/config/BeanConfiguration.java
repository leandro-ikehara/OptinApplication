package com.example.optin.infraestructure.config;

import com.example.optin.OptinApplication.service.AceiteService;
import com.example.optin.domain.ports.output.AceiteRepositoryPort;
import com.example.optin.domain.ports.output.TokenProviderPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração do Spring.
 * Responsável por "conectar" as implementações (adaptadores) com as interfaces (portas).
 * Aqui é onde a injeção de dependência da arquitetura hexagonal acontece.
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public AceiteService aceiteService(AceiteRepositoryPort aceiteRepositoryPort, TokenProviderPort tokenProviderPort) {
        return new AceiteService(aceiteRepositoryPort, tokenProviderPort);
    }
}
