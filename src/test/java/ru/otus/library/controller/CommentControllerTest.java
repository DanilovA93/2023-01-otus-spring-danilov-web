package ru.otus.library.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.service.book.BookService;
import ru.otus.library.service.comment.CommentService;

@WebFluxTest(CommentController.class)
class CommentControllerTest {

  @Autowired
  private WebTestClient client;

  @Autowired
  private ObjectMapper mapper;

  @MockBean
  private CommentService commentService;

  private CommentDtoRq commentDtoRq;

  @BeforeEach
  void before() {
    commentDtoRq = new CommentDtoRq("1", "comment");
  }

  @Test
  void save() throws Exception {
    given(commentService.save(any())).willReturn(Mono.empty());

    client.post()
        .uri("/comments")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(mapper.writeValueAsString(commentDtoRq))
        .exchange()
        .expectStatus().isOk();
  }
}