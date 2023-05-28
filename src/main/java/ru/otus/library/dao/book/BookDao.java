package ru.otus.library.dao.book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.entity.Book;

public interface BookDao {
  Mono<Book> save(Book book);
  Mono<Book> findById(String id);
  Flux<Book> findAll();
  Mono<Void> delete(String id);
}
