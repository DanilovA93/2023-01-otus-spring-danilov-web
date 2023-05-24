package ru.otus.library.dao.author;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.otus.library.entity.Author;
import ru.otus.library.repository.AuthorRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthorDaoImpl implements AuthorDao {

  private final AuthorRepository authorRepository;

  @Override
  public Author save(Author author) {
    return authorRepository.save(author);
  }

  @Override
  public Author findOneOrThrowException(String id) {
    if (id == null) {
      throw new RuntimeException("Author id is null");
    }

    return authorRepository.findById(id)
        .orElseThrow(
            () -> new RuntimeException("Author with id " + id + "  not found")
        );
  }

  @Override
  public List<Author> findAll() {
    return authorRepository.findAll();
  }

  @Override
  public void delete(String id) {
    authorRepository.deleteById(id);
  }
}
