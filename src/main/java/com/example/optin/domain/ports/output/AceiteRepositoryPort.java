package com.example.optin.domain.ports.output;

import com.example.optin.domain.model.Aceite;

/**
 * Porta de Saída (Output Port) para persistência.
 * Define o contrato que o adaptador de persistência deve implementar.
 * O domínio depende desta interface, não da implementação concreta.
 */
public interface AceiteRepositoryPort {
    Aceite salvar(Aceite aceite);
}
