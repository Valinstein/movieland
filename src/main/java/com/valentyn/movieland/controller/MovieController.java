package com.valentyn.movieland.controller;

import com.valentyn.movieland.service.MovieService;
import com.valentyn.movieland.util.JsonMapper;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Setter
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @GetMapping("/all")
    public String findAll(HttpServletResponse resp) {
        resp.setContentType("text/html;charset=utf-8");
        return JsonMapper.toJson(movieService.getAllMovies());
    }
}
