package com.example.hanghaemarket.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ErrorMessage {
    String errorMsg;

    @Builder
    private ErrorMessage(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
