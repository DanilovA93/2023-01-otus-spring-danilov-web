package ru.otus.library.service.book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.book.SimpleBookDtoRs;

public interface BookService {
  Mono<SimpleBookDtoRs> save(BookDtoRq rq);
  Flux<SimpleBookDtoRs> findAll();
  Mono<FullBookDtoRs> findById(String id);
  Mono<Void> delete(String id);
}
