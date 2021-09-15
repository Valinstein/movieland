package com.valentyn.movieland.service.impl;

import com.valentyn.movieland.dao.MovieDao;
import com.valentyn.movieland.entity.Movie;
import com.valentyn.movieland.service.MovieService;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Service
public class MovieServiceImpl implements MovieService {

    private MovieDao movieDao;

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public List<Movie> getRandomMovies(int limit) {
        return movieDao.getRandomMovies(limit);
    }
}
