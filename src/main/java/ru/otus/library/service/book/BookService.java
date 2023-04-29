package ru.otus.library.service.book;

import java.util.List;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.book.SimpleBookDtoRs;

public interface BookService {
  SimpleBookDtoRs create(BookDtoRq rq);
  List<SimpleBookDtoRs> findAll();
  FullBookDtoRs findById(Long id);
  SimpleBookDtoRs update(BookDtoRq rq);
  void delete(Long id);
}
