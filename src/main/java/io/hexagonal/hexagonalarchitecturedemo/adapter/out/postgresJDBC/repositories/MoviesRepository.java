package io.hexagonal.hexagonalarchitecturedemo.adapter.out.postgresJDBC.repositories;

import io.hexagonal.hexagonalarchitecturedemo.adapter.out.postgresJDBC.entities.MovieEntity;
import io.hexagonal.hexagonalarchitecturedemo.domain.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviesRepository extends CrudRepository<MovieEntity, Long> {

    @Query("select * from movies where title = :title")
    Optional<Movie> findMovieByTitle(@Param("title") String title);
}
