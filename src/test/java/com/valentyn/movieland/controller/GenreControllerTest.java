package com.valentyn.movieland.controller;

import com.valentyn.movieland.service.GenreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/movieland-servlet.xml")
class GenreControllerTest {


    MockMvc mockMvc;
    @Autowired
    GenreService genreService;
    @Autowired
    WebApplicationContext webApplicationContext;
    ResultMatcher ok = status().isOk();

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    @DisplayName("Check if findAll() response is json")
    void testIfFindAllIncludesGenres() throws Exception {

        RequestBuilder builder = MockMvcRequestBuilders.get("/genre/all");

        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Check if findAll() response contains genres")
    void testIfFindAllContainesGenres() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.get("/genre/all");

        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(greaterThanOrEqualTo(15))));
    }

    @Test
    @DisplayName("Check if findAll() response contains such genres")
    void testIfFindAllContainesGenresWithName() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.get("/genre/all");

        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("драма"))
                .andExpect(jsonPath("$[1].name").value("криминал"))
                .andExpect(jsonPath("$[2].name").value("фэнтези"))
                .andExpect(jsonPath("$[3].name").value("детектив"))
                .andExpect(jsonPath("$[4].name").value("мелодрама"))
                .andExpect(jsonPath("$[5].name").value("биография"))
                .andExpect(jsonPath("$[6].name").value("комедия"))
                .andExpect(jsonPath("$[7].name").value("фантастика"))
                .andExpect(jsonPath("$[8].name").value("боевик"))
                .andExpect(jsonPath("$[9].name").value("триллер"))
                .andExpect(jsonPath("$[10].name").value("приключения"))
                .andExpect(jsonPath("$[11].name").value("аниме"))
                .andExpect(jsonPath("$[12].name").value("мультфильм"))
                .andExpect(jsonPath("$[13].name").value("семейный"))
                .andExpect(jsonPath("$[14].name").value("вестерн"));
    }
}