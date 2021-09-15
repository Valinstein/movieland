package com.valentyn.movieland.dao;

import com.valentyn.movieland.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> findAll();
}
