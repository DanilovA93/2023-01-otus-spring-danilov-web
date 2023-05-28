package ru.otus.library.controller;

import static org.mockito.BDDMockito.given;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.service.author.AuthorService;

@WebFluxTest(AuthorController.class)
class AuthorControllerTest {

  @Autowired
  private WebTestClient client;

  @Autowired
  private ObjectMapper mapper;

  @MockBean
  private AuthorService authorService;

  private AuthorDtoRq authorDtoRq;
  private Mono<AuthorDtoRs> monoRs;

  @BeforeEach
  void before() {
    authorDtoRq = new AuthorDtoRq("authors");
    monoRs = Mono.just(new AuthorDtoRs("1", "authors"));
  }

  @Test
  void save() throws Exception {
    given(authorService.save(authorDtoRq)).willReturn(monoRs);

    client.post()
        .uri("/authors")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(mapper.writeValueAsString(authorDtoRq))
        .exchange()
        .expectStatus().isOk()
        .returnResult(AuthorDtoRs.class)
        .getResponseBody()
        .blockFirst();
  }

  @Test
  void findAll() throws Exception {
    Flux<AuthorDtoRs> flux = monoRs.flux();

    given(authorService.findAll()).willReturn(flux);

    client.get()
        .uri("/authors")
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .returnResult(AuthorDtoRs.class)
        .getResponseBody()
        .blockFirst();
  }

  @Test
  void deleteById() throws Exception {
    client.delete()
        .uri("/authors/" + Objects.requireNonNull(monoRs.block()).getId())
        .exchange()
        .expectStatus().isOk();
  }
}