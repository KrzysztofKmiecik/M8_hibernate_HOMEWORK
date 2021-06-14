package com.example.m8_hibernate_homework.zad1.application;

import java.util.NoSuchElementException;

public class RestApiGetException extends NoSuchElementException {
    public RestApiGetException(String s) {
        super(s);
    }
}
