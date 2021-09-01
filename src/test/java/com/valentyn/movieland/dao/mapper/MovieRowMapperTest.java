package com.valentyn.movieland.dao.mapper;

import com.valentyn.movieland.entity.Movie;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieRowMapperTest {

    @Test
    void mapRow() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);


        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name_russian")).thenReturn("Побег из Шоушенка");
        when(resultSet.getString("name_native")).thenReturn("The Shawshank Redemption");
        when(resultSet.getTimestamp("year_of_release")).thenReturn(Timestamp.valueOf("1999-01-01 20:10:20"));

        when(resultSet.getString("description")).thenReturn("Успешный банкир Энди Дюфрейн");
        when(resultSet.getDouble("rating")).thenReturn(8.89);
        when(resultSet.getDouble("price")).thenReturn(123.45);
        when(resultSet.getString("picture_path")).thenReturn("https://images-na");
        when(resultSet.getInt("votes")).thenReturn(100);

        MovieRowMapper moviesRowMapper = new MovieRowMapper();
        Movie movie = moviesRowMapper.mapRow(resultSet, anyInt());
        assertEquals(movie.getId(), 1);
        assertEquals(movie.getNameRussian(), "Побег из Шоушенка");
        assertEquals(movie.getNameNative(), "The Shawshank Redemption");
        assertEquals(movie.getYearOfRelease().getYear(), 1999);
        assertEquals(movie.getDescription(), "Успешный банкир Энди Дюфрейн");
        assertEquals(movie.getRating(), 8.89);
        assertEquals(movie.getPrice(), 123.45);
        assertEquals(movie.getPicturePath(), "https://images-na");
        assertEquals(movie.getVotes(), 100);
    }
}