package ru.otus.library.dao.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.entity.Genre;
import ru.otus.library.repository.GenreRepository;

@Component
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {

  private final GenreRepository genreRepository;

  @Override
  public Mono<Genre> save(Genre genre) {
    return genreRepository.save(genre);
  }

  @Override
  public Mono<Genre> findById(String id) {
    if (id == null) {
      throw new RuntimeException("Genre id is null");
    }

    return genreRepository.findById(id);
  }

  @Override
  public Flux<Genre> findAll() {
    return genreRepository.findAll();
  }

  @Override
  public Mono<Void> delete(String id) {
    return genreRepository.deleteById(id);
  }
}
