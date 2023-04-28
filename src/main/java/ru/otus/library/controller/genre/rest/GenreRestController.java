package ru.otus.library.controller.genre.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.facade.genre.GenreFacade;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreRestController {

  private final GenreFacade genreFacade;

  @PostMapping
  public ResponseEntity<GenreDtoRs> create(
      @RequestBody GenreDtoRq rq
  ){
    return ResponseEntity.ok(genreFacade.create(rq));
  }

  @GetMapping
  public ResponseEntity<List<GenreDtoRs>> findAll() {
    return ResponseEntity.ok(genreFacade.findAll());
  }

  @GetMapping("{genreId}")
  public ResponseEntity<GenreDtoRs> findById(
      @PathVariable Long genreId
  ){
    return ResponseEntity.ok(genreFacade.findById(genreId));
  }

  @DeleteMapping("{genreId}")
  public ResponseEntity<HttpStatus> deleteById(
      @PathVariable Long genreId
  ){
    genreFacade.deleteById(genreId);
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
