package com.example.addressbooks.dto;

import lombok.Data;



@Data
public class ResponseDto {
    private String message;
    private Object object;

    public ResponseDto(String message, Object object) {
        this.message = message;
        this.object = object;
    }

}
