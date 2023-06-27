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
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.service.author.AuthorService;

@WebMvcTest(AuthorController.class)
class AuthorControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @MockBean
  private AuthorService authorService;

  private AuthorDtoRq authorDtoRq;
  private AuthorDtoRs authorDtoRs;

  @BeforeEach
  void before() {
    authorDtoRq = new AuthorDtoRq("authors");
    authorDtoRs = new AuthorDtoRs(1L, "authors");
  }

  @Test
  void save() throws Exception {
    given(authorService.save(authorDtoRq)).willReturn(authorDtoRs);

    mvc.perform(post("/authors")
        .contentType(APPLICATION_JSON_VALUE)
        .content(mapper.writeValueAsString(authorDtoRq)))
        .andExpect(status().isForbidden());
  }

  @Test
  void findAll() throws Exception {
    List<AuthorDtoRs> authors = List.of(authorDtoRs);

    given(authorService.findAll()).willReturn(authors);

    mvc.perform(get("/authors"))
        .andExpect(status().isForbidden());
  }

  @Test
  void deleteById() throws Exception {
    mvc.perform(delete("/authors/" + authorDtoRs.getId()))
        .andExpect(status().isForbidden());
  }
}