package ru.otus.library.dao.author;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.entity.Author;

public interface AuthorDao {

  Mono<Author> save(Author author);
  Mono<Author> findById(String id);
  Flux<Author> findAll();
  Mono<Void> delete(String id);
}
