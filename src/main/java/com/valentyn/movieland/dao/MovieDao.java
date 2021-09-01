package com.valentyn.movieland.dao;

import com.valentyn.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> findAll();
}
