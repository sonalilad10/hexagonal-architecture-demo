package io.hexagonal.hexagonalarchitecturedemo.infrastructure.exceptions;

public class MovieAlreadyExistsException extends RuntimeException {

    public MovieAlreadyExistsException(String message) {
        super(message);
    }
}
