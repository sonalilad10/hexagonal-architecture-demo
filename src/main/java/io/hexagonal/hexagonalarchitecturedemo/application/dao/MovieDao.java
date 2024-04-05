package io.hexagonal.hexagonalarchitecturedemo.application.dao;

import io.hexagonal.hexagonalarchitecturedemo.application.dto.NewMovieDto;
import io.hexagonal.hexagonalarchitecturedemo.domain.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieDao {

    Optional<Movie> findMovieByTitle(String title);
    List<Movie> findAllMovies();

    void saveMovie(NewMovieDto dto);
    void updateMovie(Movie movie);
    void deleteMovie(Movie oldMovie);
}
