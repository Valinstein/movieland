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

    private static final String GET_RANDOM_MOVIES = "SELECT id, name_russian, "
            + "name_native, year_of_release, description, rating, price, "
            + "picture_path, votes FROM movie ORDER BY RANDOM() LIMIT ?;";

    private static final String GET_MOVIES_BY_GENRE = "SELECT id, name_russian, "
            + "name_native, year_of_release, description, rating, price, picture_path, votes "
            + "FROM movie LEFT JOIN movie_genre ON movie_genre.movie_id = movie.id "
            + "where movie_genre.genre_id = ?;";

    private MovieRowMapper rowMapper;

    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Movie> findAll() {
        return jdbcTemplate.query(GET_ALL_MOVIES, rowMapper);
    }

    @Override
    public List<Movie> getRandomMovies(int limit) {
        return jdbcTemplate.query(GET_RANDOM_MOVIES, rowMapper, limit);
    }

    @Override
    public List<Movie> getByGenre(int genreId) {
        return jdbcTemplate.query(GET_MOVIES_BY_GENRE, rowMapper, genreId);
    }
}
