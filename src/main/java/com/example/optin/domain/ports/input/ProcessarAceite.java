package com.example.optin.domain.ports.input;

import com.example.optin.domain.model.Aceite;

/**
 * Porta de Entrada (Input Port).
 * Define o contrato para o caso de uso de processar um aceite.
 * A camada de aplicação implementará esta interface.
 */
public interface ProcessarAceite {
    String executar(Aceite aceite);
}

