//package ru.otus.library.controller.book.rest;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import ru.otus.library.dto.book.BookDtoRq;
//import ru.otus.library.dto.book.BookDtoRs;
//import ru.otus.library.dto.comment.CommentDtoRq;
//import ru.otus.library.dto.comment.CommentDtoRs;
//import ru.otus.library.facade.book.BookFacade;
//import ru.otus.library.facade.comment.CommentFacade;
//
//@WebMvcTest(BookRestController.class)
//class BookRestControllerTest {
//
//  @Autowired
//  private MockMvc mvc;
//
//  @Autowired
//  private ObjectMapper mapper;
//
//  @MockBean
//  private BookFacade bookFacade;
//
//  @MockBean
//  private CommentFacade commentFacade;
//
//  private BookDtoRq bookDtoRq;
//  private BookDtoRs bookDtoRs;
//  private CommentDtoRq commentDtoRq;
//  private CommentDtoRs commentDtoRs;
//
//  @BeforeEach
//  void before() {
//    bookDtoRq = new BookDtoRq(1L, 1L, "genre");
//    bookDtoRs = new BookDtoRs(1L, "book");
//    commentDtoRq = new CommentDtoRq(1L,"genre");
//    commentDtoRs = new CommentDtoRs(1L, "book");
//  }
//
//  @Test
//  void create() throws Exception {
//    given(bookFacade.create(bookDtoRq)).willReturn(bookDtoRs);
//
//    mvc.perform(post("/books")
//        .content(mapper.writeValueAsString(bookDtoRq))
//        .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk())
//        .andExpect(content().json(mapper.writeValueAsString(bookDtoRs)));
//  }
//
//  @Test
//  void findAll() throws Exception {
//    List<BookDtoRs> books = List.of(bookDtoRs);
//
//    given(bookFacade.findAll()).willReturn(books);
//
//    mvc.perform(get("/books"))
//        .andExpect(status().isOk())
//        .andExpect(content().json(mapper.writeValueAsString(books)));
//  }
//
//  @Test
//  void findById() throws Exception {
//    given(bookFacade.findById(bookDtoRs.getId())).willReturn(bookDtoRs);
//
//    mvc.perform(get("/books/" + bookDtoRs.getId()))
//        .andExpect(status().isOk())
//        .andExpect(content().json(mapper.writeValueAsString(bookDtoRs)));
//  }
//
//  @Test
//  void update() throws Exception {
//    given(bookFacade.update(bookDtoRs.getId(), bookDtoRq)).willReturn(bookDtoRs);
//
//    mvc.perform(put("/books/" + bookDtoRs.getId())
//        .content(mapper.writeValueAsString(bookDtoRq))
//        .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk())
//        .andExpect(content().json(mapper.writeValueAsString(bookDtoRs)));
//  }
//
//  @Test
//  void addComment() throws Exception {
//    given(commentFacade.create(bookDtoRs.getId(), commentDtoRq)).willReturn(commentDtoRs);
//
//    mvc.perform(post("/books/" + bookDtoRs.getId() + "/comments")
//        .content(mapper.writeValueAsString(commentDtoRq))
//        .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk())
//        .andExpect(content().json(mapper.writeValueAsString(commentDtoRs)));
//  }
//
//  @Test
//  void deleteById() throws Exception {
//    mvc.perform(delete("/books/" + bookDtoRs.getId()))
//        .andExpect(status().isOk());
//  }
//}