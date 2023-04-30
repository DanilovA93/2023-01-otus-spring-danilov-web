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
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.facade.author.AuthorFacade;

@WebMvcTest(AuthorController.class)
class AuthorControllerTest {

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
  void save() throws Exception {
    given(authorFacade.create(authorDtoRq)).willReturn(authorDtoRs);

    mvc.perform(post("/authors")
        .param("action", "save")
        .content(mapper.writeValueAsString(authorDtoRq)))
        .andExpect(status().isOk());
  }

  @Test
  void findAll() throws Exception {
    List<AuthorDtoRs> authors = List.of(authorDtoRs);

    given(authorFacade.findAll()).willReturn(authors);

    mvc.perform(get("/authors"))
        .andExpect(status().isOk());
  }

  @Test
  void deleteById() throws Exception {
    mvc.perform(post("/authors/" + authorDtoRs.getId())
        .param("action", "delete"))
        .andExpect(status().isOk());
  }
}