package ru.otus.library.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.book.SimpleBookDtoRs;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.service.author.AuthorService;
import ru.otus.library.service.book.BookService;
import ru.otus.library.service.genre.GenreService;

@WebFluxTest(BookController.class)
class BookControllerTest {

  @Autowired
  private WebTestClient client;

  @Autowired
  private ObjectMapper mapper;

  @MockBean
  private BookService bookService;

  private BookDtoRq bookDtoRq;
  private Mono<SimpleBookDtoRs> monoSimpleBookDtoRs;
  private Mono<FullBookDtoRs> monoFullBookDtoRs;

  @BeforeEach
  void before() {
    bookDtoRq = new BookDtoRq("1", "1", "genre");
    monoSimpleBookDtoRs = Mono.just(new SimpleBookDtoRs("1", "book", null, null));
    monoFullBookDtoRs = Mono.just(new FullBookDtoRs("1", "book", null, null));
  }

  @Test
  void findOne() throws Exception {
    given(bookService.findById(bookDtoRq.getId())).willReturn(monoFullBookDtoRs);

    client.get()
        .uri("/books/" + bookDtoRq.getId())
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .returnResult(FullBookDtoRs.class)
        .getResponseBody()
        .blockFirst();
  }

  @Test
  void findAll() throws Exception {
    Flux<SimpleBookDtoRs> flux = monoSimpleBookDtoRs.flux();
    String url = "/books/";

    given(bookService.findAll()).willReturn(flux);

    client.get()
        .uri("/books/")
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .returnResult(SimpleBookDtoRs.class)
        .getResponseBody()
        .blockFirst();
  }

  @Test
  void save() throws Exception {
    String url = "/books/";

    given(bookService.save(bookDtoRq)).willReturn(monoSimpleBookDtoRs);

    client.post()
        .uri("/books")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(mapper.writeValueAsString(bookDtoRq))
        .exchange()
        .expectStatus().isOk()
        .returnResult(SimpleBookDtoRs.class)
        .getResponseBody()
        .blockFirst();
  }

  @Test
  void deleteById() throws Exception {
    String id = "1";
    given(bookService.delete(id)).willReturn(Mono.empty());

    client.delete()
        .uri("/books/" + id)
        .exchange()
        .expectStatus().isOk();
  }
}