//package ru.otus.library.controller.comment.rest;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import ru.otus.library.dto.comment.CommentDtoRs;
//import ru.otus.library.facade.comment.CommentFacade;
//
//@WebMvcTest(CommentRestController.class)
//class CommentRestControllerTest {
//
//  @Autowired
//  private MockMvc mvc;
//
//  @Autowired
//  private ObjectMapper mapper;
//
//  @MockBean
//  private CommentFacade commentFacade;
//
//  private CommentDtoRs commentDtoRs;
//
//  @BeforeEach
//  void before() {
//    commentDtoRs = new CommentDtoRs(1L, "comment");
//  }
//
//  @Test
//  void findById() throws Exception {
//    given(commentFacade.findById(commentDtoRs.getId())).willReturn(commentDtoRs);
//
//    mvc.perform(get("/comments/" + commentDtoRs.getId()))
//        .andExpect(status().isOk())
//        .andExpect(content().json(mapper.writeValueAsString(commentDtoRs)));
//
//  }
//
//  @Test
//  void deleteById() throws Exception {
//    mvc.perform(delete("/comments/" + commentDtoRs.getId()))
//        .andExpect(status().isOk());
//  }
//}