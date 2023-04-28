package ru.otus.library.controller.author.rest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.facade.author.AuthorFacade;

@WebMvcTest(AuthorRestController.class)
class AuthorRestControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @MockBean
  private AuthorFacade authorFacade;

  private AuthorDtoRq authorDtoRq;
  private AuthorDtoRs authorDtoRs;

  @BeforeEach
  void before() {
    authorDtoRq = new AuthorDtoRq("authors");
    authorDtoRs = new AuthorDtoRs(1L, "authors");
  }

  @Test
  void create() throws Exception {
    given(authorFacade.create(authorDtoRq)).willReturn(authorDtoRs);

    mvc.perform(post("/authors")
        .content(mapper.writeValueAsString(authorDtoRq))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json(mapper.writeValueAsString(authorDtoRq)));
  }

  @Test
  void findAll() throws Exception {
    List<AuthorDtoRs> authors = List.of(authorDtoRs);

    given(authorFacade.findAll()).willReturn(authors);

    mvc.perform(get("/authors"))
        .andExpect(status().isOk())
        .andExpect(content().json(mapper.writeValueAsString(authors)));
  }

  @Test
  void findById() throws Exception {
    given(authorFacade.findById(authorDtoRs.getId())).willReturn(authorDtoRs);

    mvc.perform(get("/authors/" + authorDtoRs.getId()))
        .andExpect(status().isOk())
        .andExpect(content().json(mapper.writeValueAsString(authorDtoRs)));

  }

  @Test
  void deleteById() throws Exception {
    mvc.perform(delete("/authors/" + authorDtoRs.getId()))
        .andExpect(status().isOk());
  }
}