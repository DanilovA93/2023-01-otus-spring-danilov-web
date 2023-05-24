package ru.otus.library.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.service.genre.GenreService;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

  private final GenreService genreService;

  @PostMapping
  public ResponseEntity<GenreDtoRs> create(@RequestBody GenreDtoRq rq) {
    return ResponseEntity.ok(genreService.save(rq));
  }

  @GetMapping
  public ResponseEntity<List<GenreDtoRs>> findAll() {
    return ResponseEntity.ok(genreService.findAll());
  }

  @DeleteMapping("{id}")
  public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
    genreService.delete(id);
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
