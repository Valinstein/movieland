package com.valentyn.movieland.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valentyn.movieland.entity.Movie;

import java.util.List;

public class JsonMapper {
        private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(List<Movie> movie) {
        try {
            return objectMapper.writeValueAsString(movie);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}