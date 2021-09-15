package com.valentyn.movieland.dao.mapper;

import com.valentyn.movieland.entity.Genre;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyByte;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GenreRowMapperTest {

    @Test
    void mapRow() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);


        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("genre_name");

        GenreRowMapper genreRowMapper = new GenreRowMapper();
        Genre genre = genreRowMapper.mapRow(resultSet, anyByte());

        assertEquals(genre.getId(), 1);
        assertEquals(genre.getName(), "genre_name");
    }
}