package ru.otus.library.service.genre;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;

public interface GenreService {
  Mono<GenreDtoRs> save(GenreDtoRq rq);
  Mono<GenreDtoRs> findById(String id);
  Flux<GenreDtoRs> findAll();
  Mono<Void> delete(String id);
}
