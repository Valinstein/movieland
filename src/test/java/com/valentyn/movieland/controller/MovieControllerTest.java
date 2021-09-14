package com.valentyn.movieland.controller;

import com.jayway.jsonpath.JsonPath;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.jayway.jsonassert.impl.matcher.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/movieland-servlet.xml")
class MovieControllerTest {

    MockMvc mockMvc;
    @Autowired
    MovieService movieService;
    @Autowired
    WebApplicationContext webApplicationContext;
    ResultMatcher ok = MockMvcResultMatchers.status().isOk();

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    @DisplayName("Check if findAll() response in json format")
    public void testIfAllMoviesIsJson() throws Exception {

        RequestBuilder builder = MockMvcRequestBuilders.get("/movie/all");
        MvcResult mvcResult = mockMvc.perform(builder).andExpect(ok)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
    }

    @Test
    @DisplayName("Check if findAll() contains a movie")
    public void testIfResponseIsJsonAndItIncludesMovie() throws Exception {
        String mockTestResult = "The Shawshank Redemption";

        RequestBuilder builder = MockMvcRequestBuilders.get("/movie/all");
        MvcResult mvcResult = mockMvc.perform(builder).andExpect(ok)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
        String res = mvcResult.getResponse().getContentAsString();
        assertTrue(res.contains(mockTestResult));
    }

    @Test
    @DisplayName("Check if getRandomMovies() response is in json format")
    public void testIfRandomMoviesAreJson() throws Exception {

        RequestBuilder builder = MockMvcRequestBuilders.get("/movie/random");
        MvcResult mvcResult = mockMvc.perform(builder).andExpect(ok)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
    }

    @Test
    @DisplayName("Check if getRandomMovies() contains a movie")
    public void testIfRandomMoviesIncludesThreeMovies() throws Exception {

        RequestBuilder builder = MockMvcRequestBuilders.get("/movie/all");
        MvcResult mvcResult = (MvcResult) mockMvc.perform(builder)
                .andExpect(jsonPath("$.*", hasSize(2)));
        String res = mvcResult.getResponse().getContentAsString();
    }
}