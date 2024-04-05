package io.hexagonal.hexagonalarchitecturedemo.application.usecases;

import io.hexagonal.hexagonalarchitecturedemo.application.dao.MovieDao;
import io.hexagonal.hexagonalarchitecturedemo.application.dto.NewMovieDto;
import io.hexagonal.hexagonalarchitecturedemo.domain.Movie;
import io.hexagonal.hexagonalarchitecturedemo.infrastructure.exceptions.MovieAlreadyExistsException;
import io.hexagonal.hexagonalarchitecturedemo.infrastructure.exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class MovieUseCase {

    @Autowired
    MovieDao movieDao;

    public String saveMovie(NewMovieDto newMovieDto) {
        var isPresent = movieDao.findMovieByTitle(newMovieDto.title()).isPresent();
        if (isPresent) {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        movieDao.saveMovie(newMovieDto);
        return "Movie Saved Successfully";
    }

    public List<Movie> getAllMovies() {
        return movieDao.findAllMovies();
    }

    public Movie getMovieByTitle(String movieTitle) {
        return movieDao.findMovieByTitle(movieTitle)
                .orElseThrow(() -> new MovieNotFoundException("This Movie does not exist"));
    }

    public String updateMovie(Movie movie) {
        var isPresent = movieDao.findMovieByTitle(movie.title()).isPresent();
        if (isPresent) {
            throw new MovieNotFoundException("This Movie does not exist");
        }
        movieDao.updateMovie(movie);
        return "Movie updated Successfully";
    }

    public String deleteMovie(Movie oldMovie) {
        var isPresent = movieDao.findMovieByTitle(oldMovie.title()).isPresent();
        if (isPresent) {
            throw new MovieNotFoundException("This Movie is not exist");
        }
        movieDao.deleteMovie(oldMovie);
        return "Movie deleted Successfully";
    }
}
