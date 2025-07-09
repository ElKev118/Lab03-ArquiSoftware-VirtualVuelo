package com.udea.virtualvuelo.exception;

public class InvalidRate extends RuntimeException {

    public InvalidRate() {
        super();
    }

    public InvalidRate(String message) {
        super(message);
    }
}
