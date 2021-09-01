package com.valentyn.movieland.dao.mapper;

import com.valentyn.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        return Movie.builder()
                .id(resultSet.getInt("id"))
                .nameRussian(resultSet.getString("name_russian"))
                .nameNative(resultSet.getString("name_native"))
                .yearOfRelease(resultSet.getTimestamp("year_of_release").toLocalDateTime())
                .description(resultSet.getString("description"))
                .rating(resultSet.getDouble("rating"))
                .price(resultSet.getDouble("price"))
                .picturePath(resultSet.getString("picture_path"))
                .votes(resultSet.getInt("votes"))
                .build();
    }
}
