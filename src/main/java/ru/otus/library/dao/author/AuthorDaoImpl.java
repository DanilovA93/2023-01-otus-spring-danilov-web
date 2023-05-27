package ru.otus.library.dao.author;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.entity.Author;
import ru.otus.library.repository.AuthorRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthorDaoImpl implements AuthorDao {

  private final AuthorRepository authorRepository;

  @Override
  public Mono<Author> save(Author author) {
    return authorRepository.save(author);
  }

  @Override
  public Mono<Author> findById(String id) {
    if (id == null) {
      throw new RuntimeException("Author id is null");
    }

    return authorRepository.findById(id);
  }

  @Override
  public Flux<Author> findAll() {
    return authorRepository.findAll();
  }

  @Override
  public Mono<Void> delete(String id) {
    return authorRepository.deleteById(id);
  }
}
