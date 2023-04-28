package ru.otus.library.dao.genre;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.library.entity.Genre;
import ru.otus.library.repository.GenreRepository;

@Component
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {

  private final GenreRepository genreRepository;

  @Override
  public Genre save(Genre genre) {
    return genreRepository.save(genre);
  }

  @Override
  public Genre findOneOrThrowException(Long id) {
    if (id == null) {
      throw new RuntimeException("Genre id is null");
    }

    return genreRepository
        .findById(id)
        .orElseThrow(
            () -> new RuntimeException("Genre with id " + id + "  not found")
        );
  }

  @Override
  public List<Genre> findAll() {
    return genreRepository.findAll();
  }

  @Override
  public void delete(Long id) {
    genreRepository.deleteById(id);
  }
}
