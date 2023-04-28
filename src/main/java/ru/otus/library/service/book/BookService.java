package ru.otus.library.service.book;

import java.util.List;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.BookDtoRs;
import ru.otus.library.entity.Book;

public interface BookService {
  BookDtoRs create(BookDtoRq rq);
  List<BookDtoRs> findAll();
  BookDtoRs findById(Long id);
  BookDtoRs update(BookDtoRq rq);
  void delete(Long id);
}
