package com.ms.order.constant;
import lombok.Getter;

public enum ErrorCode {
    BAD_REQUEST("Solicitação inválida"),
    INVALID_PARAMETER("Paramêtro da solicitação inválido"),
    INTERNAL_SERVER_ERROR("Erro interno do servidor"),
    ORDER_NOT_FOUND("Pedido não encontrado"),
    ITEM_NOT_FOUND("Item não encontrado");
    @Getter
    private final String message;

    ErrorCode(String message){
        this.message = message;
    }
}
