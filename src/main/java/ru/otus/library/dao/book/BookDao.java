package ru.otus.library.dao.book;

import java.util.List;
import ru.otus.library.entity.Book;

public interface BookDao {
  Book save(Book book);
  Book findOneOrThrowException(String id);
  List<Book> findAll();
  void delete(String id);
}
