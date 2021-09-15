package com.valentyn.movieland.controller;

import com.valentyn.movieland.entity.Genre;
import com.valentyn.movieland.service.GenreService;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Setter
@RequestMapping("/genre")
public class GenreController {

    private GenreService genreService;

    @GetMapping("/all")
    public List<Genre> findAll(HttpServletResponse response) {
        return genreService.findAll();
    }
}
