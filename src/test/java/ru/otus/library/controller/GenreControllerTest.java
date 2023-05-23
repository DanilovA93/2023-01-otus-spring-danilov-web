package ru.otus.library.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.service.genre.GenreService;

@WebMvcTest(GenreController.class)
class GenreControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @MockBean
  private GenreService genreService;

  private GenreDtoRq genreDtoRq;
  private GenreDtoRs genreDtoRs;

  @BeforeEach
  void before() {
    genreDtoRq = new GenreDtoRq("genre");
    genreDtoRs = new GenreDtoRs(1L, "genre");
  }

  @Test
  void save() throws Exception {
    given(genreService.save(genreDtoRq)).willReturn(genreDtoRs);

    mvc.perform(post("/genres")
        .contentType(APPLICATION_JSON_VALUE)
        .content(mapper.writeValueAsString(genreDtoRq)))
        .andExpect(status().isOk());
  }

  @Test
  void findAll() throws Exception {
    List<GenreDtoRs> genres = List.of(genreDtoRs);

    given(genreService.findAll()).willReturn(genres);

    mvc.perform(get("/genres"))
        .andExpect(status().isOk());
  }

  @Test
  void deleteById() throws Exception {
    mvc.perform(delete("/genres/" + genreDtoRs.getId()))
        .andExpect(status().isOk());
  }
}