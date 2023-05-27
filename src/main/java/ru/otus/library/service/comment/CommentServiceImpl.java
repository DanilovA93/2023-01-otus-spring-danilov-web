package ru.otus.library.service.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import ru.otus.library.dao.book.BookDao;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.entity.Comment;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final BookDao bookDao;

  @Override
  @Transactional
  public Mono<Void> save(CommentDtoRq rq) {
    Comment comment = new Comment(rq.getText());

    return bookDao.findById(rq.getBookId())
        .doOnNext(book -> book.addComment(comment))
        .doOnNext(bookDao::save)
        .then();
  }

  @Override
  public Mono<Void> delete(String id) {
    return bookDao.delete(id);
  }
}
