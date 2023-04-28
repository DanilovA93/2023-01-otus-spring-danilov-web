package ru.otus.library.service.book;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dao.author.AuthorDao;
import ru.otus.library.dao.book.BookDao;
import ru.otus.library.dao.genre.GenreDao;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.BookDtoRs;
import ru.otus.library.entity.Book;
import ru.otus.library.mapper.BookMapper;

@Component
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookDao bookDao;
  private final AuthorDao authorDao;
  private final GenreDao genreDao;
  private final BookMapper bookMapper;

  @Override
  @Transactional
  public BookDtoRs create(BookDtoRq rq) {
    Book book = bookMapper.map(rq);
    fill(book, rq);
    book = bookDao.save(book);//todo надо липереопределять или id подтянется?
    return bookMapper.map(book);
  }

  @Override
  @Transactional(readOnly = true)
  public List<BookDtoRs> findAll() {
    return bookDao.findAll().stream()
        .map(bookMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional(readOnly = true)
  public BookDtoRs findById(Long id) {
    return bookMapper.map(bookDao.findOneOrThrowException(id));
  }

  @Override
  @Transactional
  public BookDtoRs update(BookDtoRq rq) {
    Book book = bookDao.findOneOrThrowException(rq.getId());
    fill(book, rq);

    return bookMapper.map(bookDao.save(book));
  }

  @Override
  public void delete(Long id) {
    bookDao.delete(id);
  }

  private void fill(Book book, BookDtoRq rq) {
    book.setAuthor(authorDao.findOneOrThrowException(rq.getAuthorId()));
    book.setGenre(genreDao.findOneOrThrowException(rq.getGenreId()));
    book.setName(rq.getName());
  }
}