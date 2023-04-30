package ru.otus.library.facade.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.book.SimpleBookDtoRs;
import ru.otus.library.service.book.BookService;

@Component
@RequiredArgsConstructor
public class BookFacadeImpl implements BookFacade {

  private final BookService bookService;

  @Override
  public SimpleBookDtoRs save(BookDtoRq rq) {
    return bookService.create(rq);
  }

  @Override
  public List<SimpleBookDtoRs> findAll() {
    return bookService.findAll();
  }

  @Override
  public FullBookDtoRs findById(Long id) {
    return bookService.findById(id);
  }

  @Override
  public SimpleBookDtoRs update(Long bookId, BookDtoRq rq) {
    rq.setId(bookId);
    return bookService.update(rq);
  }

  @Override
  public void deleteById(Long id) {
    bookService.delete(id);
  }
}
