package com.example.ted.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException{

    private final String msg;

    public EntityNotFoundException(String msg) {
        this.msg = msg;
    }

}
