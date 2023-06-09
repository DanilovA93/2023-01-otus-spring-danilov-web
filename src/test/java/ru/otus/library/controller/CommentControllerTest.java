package ru.otus.library.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.service.book.BookService;
import ru.otus.library.service.comment.CommentService;

@WebMvcTest(CommentController.class)
class CommentControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private CommentService commentService;

  @MockBean
  private BookService bookService;

  private CommentDtoRq commentDtoRq;
  private CommentDtoRs commentDtoRs;
  private FullBookDtoRs bookDtoRs;

  @BeforeEach
  void before() {
    commentDtoRq = new CommentDtoRq(1L, 1L, "comment");
    commentDtoRs = new CommentDtoRs(1L, "comment");
    bookDtoRs = new FullBookDtoRs();
    bookDtoRs.setId(1L);
    bookDtoRs.setName("name");
    bookDtoRs.setAuthor(new AuthorDtoRs(1L, "name"));
    bookDtoRs.setGenre(new GenreDtoRs(1L, "name"));
  }

  @Test
  void save() throws Exception {
    given(commentService.save(any())).willReturn(commentDtoRs);
    given(bookService.findById(anyLong())).willReturn(bookDtoRs);

    mvc.perform(
        post("/comments")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            .param("id",      commentDtoRq.getId().toString())
            .param("bookId",  commentDtoRq.getBookId().toString())
            .param("text",    commentDtoRq.getText())
            .param("action", "save")
    ).andExpect(status().isForbidden());
  }

  @Test
  void delete() throws Exception {
    doNothing().when(bookService).delete(any());
    given(bookService.findById(anyLong())).willReturn(bookDtoRs);

    mvc.perform(
        post("/comments")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            .param("id",      commentDtoRq.getId().toString())
            .param("bookId",  commentDtoRq.getBookId().toString())
            .param("text",    commentDtoRq.getText())
            .param("action", "delete")
    ).andExpect(status().isForbidden());
  }
}