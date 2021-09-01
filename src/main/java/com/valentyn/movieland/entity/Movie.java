package com.valentyn.movieland.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private long id;
    private String nameRussian;
    private String nameNative;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private LocalDateTime yearOfRelease;
    private String description;
    private double rating;
    private double price;
    private String picturePath;
    private int votes;
}
