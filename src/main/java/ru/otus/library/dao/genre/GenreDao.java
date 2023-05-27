package ru.otus.library.dao.genre;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.entity.Genre;

public interface GenreDao {

  Mono<Genre> save(Genre genre);
  Mono<Genre> findById(String genreId);
  Flux<Genre> findAll();
  Mono<Void> delete(String id);
}
