package ru.otus.library.service.author;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;

public interface AuthorService {
  Mono<AuthorDtoRs> save(AuthorDtoRq rq);
  Mono<AuthorDtoRs> findById(String id);
  Flux<AuthorDtoRs> findAll();
  Mono<Void> delete(String id);
}
