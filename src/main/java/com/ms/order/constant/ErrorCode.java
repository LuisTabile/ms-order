package com.ms.order.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    //Erros comuns
    BAD_REQUEST("Solicitação inválida"),
    INVALID_PARAMETER("Paramêtro da solicitação inválido"),
    INTERNAL_SERVER_ERROR("Erro interno do servidor"),
    //Erros Not Found
    ORDER_NOT_FOUND("Pedido não encontrado");
    private final String message;
    }
