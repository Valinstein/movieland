package com.valentyn.movieland.dao.jdbc;

import com.valentyn.movieland.dao.GenreDao;
import com.valentyn.movieland.dao.mapper.GenreRowMapper;
import com.valentyn.movieland.entity.Genre;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class GenreDaoImpl implements GenreDao {

    private static final String GET_ALL_GENRES = "SELECT id, name FROM genre;";

    private JdbcTemplate jdbcTemplate;

    private GenreRowMapper genreRowMapper;

    @Override
    public List<Genre> findAll() {
        return jdbcTemplate.query(GET_ALL_GENRES, genreRowMapper);
    }
}
