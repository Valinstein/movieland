package com.valentyn.movieland.dao.jdbc;

import com.valentyn.movieland.dao.MovieDao;
import com.valentyn.movieland.dao.mapper.MovieRowMapper;
import com.valentyn.movieland.entity.Movie;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class MovieDaoImpl implements MovieDao {

    private static final String GET_ALL_MOVIES = "SELECT id, name_russian, "
        + "name_native, year_of_release, description, rating, price, "
        + "picture_path, votes FROM movie;";

    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Movie> findAll() {
        return jdbcTemplate.query(GET_ALL_MOVIES, new MovieRowMapper());
    }
}
