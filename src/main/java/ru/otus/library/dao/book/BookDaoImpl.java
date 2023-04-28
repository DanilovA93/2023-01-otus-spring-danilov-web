package ru.otus.library.dao.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.entity.Book;
import ru.otus.library.repository.BookRepository;

@Component
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

  private final BookRepository bookRepository;

  @Override
  public Book save(Book book) {
    return bookRepository.save(book);
  }

  @Override
  public Book findOneOrThrowException(Long id) {
    if (id == null) {
      throw new RuntimeException("Book id is null");
    }

    return bookRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Book with id " + id + "  not found"));
  }

  @Override
  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  @Override
  public void delete(Long id) {
    bookRepository.deleteById(id);
  }
}
