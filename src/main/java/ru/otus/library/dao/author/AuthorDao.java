package ru.otus.library.dao.author;

import java.util.List;
import ru.otus.library.entity.Author;

public interface AuthorDao {

  Author save(Author author);
  Author findOneOrThrowException(String id);
  List<Author> findAll();
  void delete(String id);
}
