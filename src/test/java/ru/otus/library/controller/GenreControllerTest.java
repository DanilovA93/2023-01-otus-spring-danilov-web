package ru.otus.library.controller;

import static org.mockito.BDDMockito.given;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.service.genre.GenreService;

@WebFluxTest(GenreController.class)
class GenreControllerTest {

  @Autowired
  private WebTestClient client;

  @Autowired
  private ObjectMapper mapper;

  @MockBean
  private GenreService genreService;

  private GenreDtoRq genreDtoRq;
  private Mono<GenreDtoRs> monoRs;

  @BeforeEach
  void before() {
    genreDtoRq = new GenreDtoRq("genre");
    monoRs = Mono.just(new GenreDtoRs("1", "genre"));
  }

  @Test
  void save() throws Exception {
    given(genreService.save(genreDtoRq)).willReturn(monoRs);

    client.post()
        .uri("/genres")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(mapper.writeValueAsString(genreDtoRq))
        .exchange()
        .expectStatus().isOk()
        .returnResult(GenreDtoRs.class)
        .getResponseBody()
        .blockFirst();
  }

  @Test
  void findAll() throws Exception {
    Flux<GenreDtoRs> flux = monoRs.flux();

    given(genreService.findAll()).willReturn(flux);

    client.get()
        .uri("/genres")
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .returnResult(GenreDtoRs.class)
        .getResponseBody()
        .blockFirst();
  }

  @Test
  void deleteById() throws Exception {
    client.delete()
        .uri("/genres/" + Objects.requireNonNull(monoRs.block()).getId())
        .exchange()
        .expectStatus().isOk();
  }
}