package io.hexagonal.hexagonalarchitecturedemo.adapter.in;

import io.hexagonal.hexagonalarchitecturedemo.application.dto.NewMovieDto;
import io.hexagonal.hexagonalarchitecturedemo.application.usecases.MovieUseCase;
import io.hexagonal.hexagonalarchitecturedemo.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {
    @Autowired
    MovieUseCase movieUseCase;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("tested");
    }

    @GetMapping
    public ResponseEntity<?> getAllMovies() {
        return ResponseEntity.ok(movieUseCase.getAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(movieUseCase.getMovieByTitle(title));
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody NewMovieDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.saveMovie(dto));
    }

    @PutMapping
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.OK).body(movieUseCase.updateMovie(movie));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.OK).body(movieUseCase.deleteMovie(movie));
    }
}
