package ru.otus.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.service.genre.GenreService;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

  private final GenreService genreService;

  @PostMapping
  public Mono<GenreDtoRs> create(@RequestBody GenreDtoRq rq) {
    return genreService.save(rq);
  }

  @GetMapping
  public Flux<GenreDtoRs> findAll() {
    return genreService.findAll();
  }

  @DeleteMapping("{id}")
  public Mono<Void> delete(@PathVariable String id) {
    return genreService.delete(id);
  }
}
