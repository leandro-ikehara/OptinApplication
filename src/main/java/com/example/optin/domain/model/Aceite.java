package com.example.optin.domain.model;

import java.time.LocalDateTime;

/**
 * Representa a entidade de negócio (domínio) do Aceite.
 * Esta classe não tem conhecimento de frameworks externos (como JPA ou Spring).
 */
public class Aceite {
    private String idUsuario;
    private boolean consentimento;
    private LocalDateTime dataHora;
    private String canal; // Ex: "APP_MOBILE", "WEBSITE"

    public Aceite(String idUsuario, boolean consentimento, String canal) {
        if (idUsuario == null || idUsuario.isBlank()) {
            throw new IllegalArgumentException("ID do usuário não pode ser nulo ou vazio.");
        }
        if (!consentimento) {
            throw new IllegalArgumentException("O consentimento deve ser verdadeiro para processar o aceite.");
        }
        this.idUsuario = idUsuario;
        this.consentimento = consentimento;
        this.canal = canal;
        this.dataHora = LocalDateTime.now();
    }

    // Getters
    public String getIdUsuario() {
        return idUsuario;
    }

    public boolean isConsentimento() {
        return consentimento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getCanal() {
        return canal;
    }
}
