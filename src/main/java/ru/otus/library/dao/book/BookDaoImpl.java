package ru.otus.library.dao.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.entity.Book;
import ru.otus.library.repository.BookRepository;

@Component
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

  private final BookRepository bookRepository;

  @Override
  public Mono<Book> save(Book book) {
    return bookRepository.save(book);
  }

  @Override
  public Mono<Book> findById(String id) {
    if (id == null) {
      throw new RuntimeException("Book id is null");
    }

    return bookRepository.findById(id);
  }

  @Override
  public Flux<Book> findAll() {
    return bookRepository.findAll();
  }

  @Override
  public Mono<Void> delete(String id) {
    return bookRepository.deleteById(id);
  }
}
