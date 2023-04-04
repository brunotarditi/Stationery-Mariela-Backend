package com.mariela.stationery.dtos;

import org.springframework.beans.factory.annotation.Value;

public class MessageDto {
    public static final String UPDATE_FAIL = "No pudo actualizarse.";
    public static final String DELETE_FAIL = "No pudo eliminarse.";
    public static final String DELETE_SUCCESS = "Eliminado con éxito.";
    public static final String NOT_FOUND = "No encontrado.";

    @Value("${message.not.found}")
    private String notFound;
    private String text;
    public MessageDto() {
    }

    public MessageDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
