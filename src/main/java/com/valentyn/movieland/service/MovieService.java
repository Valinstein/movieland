package com.valentyn.movieland.service;

import com.valentyn.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    List<Movie> getRandomMovies(int limit);

    List<Movie> findByGenre(int genreId);
}
