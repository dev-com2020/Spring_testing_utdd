package com.example.demo.dto;

import java.io.Serializable;


public class MessageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String message;

    public MessageDTO(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}