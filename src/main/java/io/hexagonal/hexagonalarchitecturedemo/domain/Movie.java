package io.hexagonal.hexagonalarchitecturedemo.domain;

import lombok.Data;

import java.time.LocalDate;


public record Movie(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        String directorName){
}
