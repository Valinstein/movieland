package com.valentyn.movieland.service.impl;

import com.valentyn.movieland.dao.GenreDao;
import com.valentyn.movieland.entity.Genre;
import com.valentyn.movieland.service.GenreService;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Service
public class GenreServiceImpl implements GenreService {

    private GenreDao genreDao;


    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }
}
