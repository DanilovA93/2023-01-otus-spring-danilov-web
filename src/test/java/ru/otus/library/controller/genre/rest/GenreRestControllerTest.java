//package ru.otus.library.controller.genre.rest;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
//import ru.otus.library.dto.genre.GenreDtoRq;
//import ru.otus.library.dto.genre.GenreDtoRs;
//import ru.otus.library.facade.genre.GenreFacade;
//
//@WebMvcTest(GenreRestController.class)
//class GenreRestControllerTest {
//
//  @Autowired
//  private MockMvc mvc;
//
//  @Autowired
//  private ObjectMapper mapper;
//
//  @MockBean
//  private GenreFacade genreFacade;
//
//  private GenreDtoRq genreDtoRq;
//  private GenreDtoRs genreDtoRs;
//
//  @BeforeEach
//  void before() {
//    genreDtoRq = new GenreDtoRq("genre");
//    genreDtoRs = new GenreDtoRs(1L, "genre");
//  }
//
//  @Test
//  void create() throws Exception {
//    given(genreFacade.create(genreDtoRq)).willReturn(genreDtoRs);
//
//    mvc.perform(post("/genres")
//        .content(mapper.writeValueAsString(genreDtoRq))
//        .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk())
//        .andExpect(content().json(mapper.writeValueAsString(genreDtoRs)));
//  }
//
//  @Test
//  void findAll() throws Exception {
//    List<GenreDtoRs> genres = List.of(genreDtoRs);
//
//    given(genreFacade.findAll()).willReturn(genres);
//
//    mvc.perform(get("/genres"))
//        .andExpect(status().isOk())
//        .andExpect(content().json(mapper.writeValueAsString(genres)));
//  }
//
//  @Test
//  void findById() throws Exception {
//    given(genreFacade.findById(genreDtoRs.getId())).willReturn(genreDtoRs);
//
//    mvc.perform(get("/genres/" + genreDtoRs.getId()))
//        .andExpect(status().isOk())
//        .andExpect(content().json(mapper.writeValueAsString(genreDtoRs)));
//  }
//
//  @Test
//  void deleteById() throws Exception {
//    mvc.perform(delete("/genres/" + genreDtoRs.getId()))
//        .andExpect(status().isOk());
//  }
//}