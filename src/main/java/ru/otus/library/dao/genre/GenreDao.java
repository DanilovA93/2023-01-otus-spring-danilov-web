package ru.otus.library.dao.genre;

import java.util.List;
import ru.otus.library.entity.Author;
import ru.otus.library.entity.Genre;

public interface GenreDao {

  Genre save(Genre genre);
  Genre findOneOrThrowException(String genreId);
  List<Genre> findAll();
  void delete(String id);
}
