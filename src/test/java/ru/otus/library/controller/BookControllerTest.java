package ru.otus.library.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.book.SimpleBookDtoRs;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.service.author.AuthorService;
import ru.otus.library.service.book.BookService;
import ru.otus.library.service.genre.GenreService;

@WebMvcTest(BookController.class)
class BookControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private BookService bookService;

  @MockBean
  private AuthorService authorService;

  @MockBean
  private GenreService genreService;

  private BookDtoRq bookDtoRq;
  private SimpleBookDtoRs simpleBookDtoRs;
  private FullBookDtoRs fullBookDtoRs;
  private AuthorDtoRs authorDtoRs;
  private GenreDtoRs genreDtoRs;

  @BeforeEach
  void before() {
    bookDtoRq = new BookDtoRq(1L, 1L, "genre");
    authorDtoRs = new AuthorDtoRs(1L,"name");
    genreDtoRs = new GenreDtoRs(1L,"name");
    simpleBookDtoRs = new SimpleBookDtoRs(1L, "book", authorDtoRs, genreDtoRs);
    fullBookDtoRs = new FullBookDtoRs(1L, "book", authorDtoRs, genreDtoRs);
  }

  @Test
  void findOne() throws Exception {
    Long id = 1L;
    String url = "/books/" + id;

    given(bookService.findById(id)).willReturn(fullBookDtoRs);

    mvc.perform(get(url)).andExpect(status().isOk());
  }

  @Test
  void findAll() throws Exception {
    String url = "/books/";
    List<SimpleBookDtoRs> list = List.of(simpleBookDtoRs);

    given(bookService.findAll()).willReturn(list);

    mvc.perform(get(url)).andExpect(status().isOk());
  }

  @Test
  void save() throws Exception {
    String url = "/books/";

    given(bookService.save(bookDtoRq)).willReturn(simpleBookDtoRs);

    mvc.perform(post(url)
        .param("action", "save"))
        .andExpect(status().isOk());
  }

  @Test
  void deleteById() throws Exception {
    List<SimpleBookDtoRs> books = List.of(simpleBookDtoRs);
    List<AuthorDtoRs> authors = List.of(authorDtoRs);
    List<GenreDtoRs> genres = List.of(genreDtoRs);
    Long id = 1L;
    String url = "/books/";

    doNothing().when(bookService).delete(id);
    given(bookService.findAll()).willReturn(books);
    given(authorService.findAll()).willReturn(authors);
    given(genreService.findAll()).willReturn(genres);

    mvc.perform(post(url)
        .param("action", "delete"))
        .andExpect(status().isOk());
  }
}