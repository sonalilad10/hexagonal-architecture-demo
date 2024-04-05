package io.hexagonal.hexagonalarchitecturedemo.adapter.out.postgresJDBC;

import io.hexagonal.hexagonalarchitecturedemo.adapter.out.postgresJDBC.entities.MovieEntity;
import io.hexagonal.hexagonalarchitecturedemo.adapter.out.postgresJDBC.repositories.MoviesRepository;
import io.hexagonal.hexagonalarchitecturedemo.application.dao.MovieDao;
import io.hexagonal.hexagonalarchitecturedemo.application.dto.NewMovieDto;
import io.hexagonal.hexagonalarchitecturedemo.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class MoviesDaoAdapter implements MovieDao {

    @Autowired
    MoviesRepository moviesRepository;

    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return moviesRepository.findMovieByTitle(title);
    }

    @Override
    public List<Movie> findAllMovies() {
        return ((List<MovieEntity>) moviesRepository.findAll())
                .stream()
                .map(movieEntity -> new Movie(
                        movieEntity.id(),
                        movieEntity.title(),
                        movieEntity.description(),
                        movieEntity.releaseDate(),
                        movieEntity.directorName()
                ))
                .toList();
    }

    @Override
    public void saveMovie(NewMovieDto dto) {
        moviesRepository.save(new MovieEntity(
                null,
                dto.title(),
                dto.description(),
                dto.releaseDate(),
                dto.directorName(),
                null
        ));
    }

    @Override
    public void updateMovie(Movie movie) {
        moviesRepository.save(new MovieEntity(
                movie.id(),
                movie.title(),
                movie.description(),
                movie.releaseDate(),
                movie.directorName(),
                null
        ));
    }

    @Override
    public void deleteMovie(Movie oldMovie) {
        moviesRepository.delete(new MovieEntity(oldMovie.id(),
                oldMovie.title(),
                oldMovie.description(),
                oldMovie.releaseDate(),
                oldMovie.directorName(),
                null));
    }
}
