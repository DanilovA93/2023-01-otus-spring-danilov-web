package ru.otus.library.facade.book;

import java.util.List;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.BookDtoRs;

public interface BookFacade {

  BookDtoRs create(BookDtoRq rq);
  List<BookDtoRs> findAll();
  BookDtoRs findById(Long id);
  BookDtoRs update(Long bookId, BookDtoRq rq);
  void delete(Long id);
}
