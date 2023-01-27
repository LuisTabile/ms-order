package com.ms.history.constants;

import lombok.Getter;

public enum ErrorCode {
 INTERNAL_SERVER_ERROR("Erro interno no Servidor");
    @Getter
    private final String message;

    ErrorCode(String message){
        this.message = message;
    }
}

