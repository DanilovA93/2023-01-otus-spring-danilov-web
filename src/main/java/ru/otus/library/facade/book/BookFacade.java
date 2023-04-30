package ru.otus.library.facade.book;

import java.util.List;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.book.SimpleBookDtoRs;

public interface BookFacade {

  SimpleBookDtoRs save(BookDtoRq rq);
  FullBookDtoRs findById(Long id);
  List<SimpleBookDtoRs> findAll();
  SimpleBookDtoRs update(Long bookId, BookDtoRq rq);
  void deleteById(Long id);
}
