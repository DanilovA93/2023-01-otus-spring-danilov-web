package ru.otus.library.service.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.dao.author.AuthorDao;
import ru.otus.library.dao.book.BookDao;
import ru.otus.library.dao.genre.GenreDao;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.book.SimpleBookDtoRs;
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
  public Mono<SimpleBookDtoRs> save(BookDtoRq rq) {
    return Mono.just(new Book())
        .doOnNext(s -> s.setName(rq.getName()))
        .doOnNext(s -> s.setAuthor(authorDao.findById(rq.getAuthorId()).block()))
        .doOnNext(s -> s.setGenre(genreDao.findById(rq.getGenreId()).block()))
        .doOnNext(bookDao::save)
        .map(bookMapper::mapToSimple);
  }

  @Override
  @Transactional(readOnly = true)
  public Flux<SimpleBookDtoRs> findAll() {
    return bookDao.findAll()
        .map(bookMapper::mapToSimple);
  }

  @Override
  @Transactional(readOnly = true)
  public Mono<FullBookDtoRs> findById(String id) {
    return bookDao.findById(id)
        .map(bookMapper::mapToFull);
  }

  @Override
  public Mono<Void> delete(String id) {
    return bookDao.delete(id);
  }
}
