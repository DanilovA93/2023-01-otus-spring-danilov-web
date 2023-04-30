package ru.otus.library.controller;

import static org.mockito.BDDMockito.given;
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
import ru.otus.library.facade.genre.GenreFacade;

@WebMvcTest(GenreController.class)
class GenreControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @MockBean
  private GenreFacade genreFacade;

  private GenreDtoRq genreDtoRq;
  private GenreDtoRs genreDtoRs;

  @BeforeEach
  void before() {
    genreDtoRq = new GenreDtoRq("genre");
    genreDtoRs = new GenreDtoRs(1L, "genre");
  }

  @Test
  void save() throws Exception {
    given(genreFacade.create(genreDtoRq)).willReturn(genreDtoRs);

    mvc.perform(post("/genres")
        .param("action", "save")
        .content(mapper.writeValueAsString(genreDtoRq)))
        .andExpect(status().isOk());
  }

  @Test
  void findAll() throws Exception {
    List<GenreDtoRs> genres = List.of(genreDtoRs);

    given(genreFacade.findAll()).willReturn(genres);

    mvc.perform(get("/genres"))
        .andExpect(status().isOk());
  }

  @Test
  void deleteById() throws Exception {
    mvc.perform(post("/genres/" + genreDtoRs.getId())
        .param("action", "delete"))
        .andExpect(status().isOk());
  }
}