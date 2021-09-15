package com.valentyn.movieland.controller;

import com.valentyn.movieland.entity.Movie;
import com.valentyn.movieland.service.MovieService;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Setter
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @GetMapping("/all")
    public List<Movie> findAll(HttpServletResponse response) {
        return movieService.getAllMovies();
    }

    @GetMapping("/random")
    public List<Movie> getRandomMovies(@RequestParam (defaultValue = "3", name = "limit") String limit,
                                       HttpServletResponse response){

        return movieService.getRandomMovies(Integer.parseInt(limit));
    }

    @GetMapping("/genre/{genreId}")
    public List<Movie> getMoviesByGenre(@PathVariable int genreId,
                                        HttpServletResponse response){
        return movieService.findByGenre(genreId);
    }
}