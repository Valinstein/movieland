package com.valentyn.movieland.controller;

import com.valentyn.movieland.service.MovieService;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/movieland-servlet.xml")
class MovieControllerTest {

    MockMvc mockMvc;
    @Autowired
    MovieService movieService;
    @Autowired
    WebApplicationContext webApplicationContext;
    ResultMatcher ok = status().isOk();

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    @DisplayName("Check if findAll() response is not empty")
    public void testIfRandomMoviesIncludesThreeMoviesOrMore() throws Exception {

        RequestBuilder builder = MockMvcRequestBuilders.get("/movie/all");
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))));

    }

    @Test
    @DisplayName("Check if findAll() response contains a movie")
    public void testIfResponseIsJsonAndItIncludesMovie() throws Exception {
        String mockTestResult = "The Shawshank Redemption";

        RequestBuilder builder = MockMvcRequestBuilders.get("/movie/all");
        MvcResult mvcResult = mockMvc.perform(builder).andExpect(ok)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
        String res = mvcResult.getResponse().getContentAsString();
        assertTrue(res.contains(mockTestResult));
    }

    @Test
    @DisplayName("Check if findAll() response in json format")
    public void testIfAllMoviesIsJson() throws Exception {

        RequestBuilder builder = MockMvcRequestBuilders.get("/movie/all");
        mockMvc.perform(builder)
                .andExpect(ok)
                .andExpect(content()
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Check if getRandomMovies() response is json format")
    public void testIfRandomMoviesAreJson() throws Exception {

        RequestBuilder builder = MockMvcRequestBuilders.get("/movie/random");
        mockMvc.perform(builder)
                .andExpect(ok)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    @DisplayName("Check if getRandomMovies() response has movies")
    public void testIfRandomMoviesNotEmpty() throws Exception {

        RequestBuilder builder = MockMvcRequestBuilders.get("/movie/random");
        mockMvc.perform(builder).andExpect(ok)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", hasSize(greaterThanOrEqualTo(3))));
    }
}