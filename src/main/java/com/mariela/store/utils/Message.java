package com.mariela.store.utils;

public class Message {
    public static final String UPDATE_FAIL = "No pudo actualizarse.";
    public static final String DELETE_FAIL = "No pudo eliminarse.";
    public static final String DELETE_SUCCESS = "Eliminado con éxito.";
    private String text;
    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
