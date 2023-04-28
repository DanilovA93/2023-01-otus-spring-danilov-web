package ru.otus.library.facade.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.BookDtoRs;
import ru.otus.library.service.book.BookService;

@Component
@RequiredArgsConstructor
public class BookFacadeImpl implements BookFacade {

  private final BookService bookService;

  @Override
  public BookDtoRs create(BookDtoRq rq) {
    return bookService.create(rq);
  }

  @Override
  public List<BookDtoRs> findAll() {
    return bookService.findAll();
  }

  @Override
  public BookDtoRs findById(Long id) {
    return bookService.findById(id);
  }

  @Override
  public BookDtoRs update(Long bookId, BookDtoRq rq) {
    rq.setId(bookId);
    return bookService.update(rq);
  }

  @Override
  public void delete(Long id) {
    bookService.delete(id);
  }
}
