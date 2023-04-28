package ru.otus.library.service.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dao.book.BookDao;
import ru.otus.library.dao.comment.CommentDao;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Comment;
import ru.otus.library.mapper.CommentMapper;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final CommentDao commentDao;
  private final BookDao bookDao;
  private final CommentMapper commentMapper;

  @Override
  @Transactional
  public CommentDtoRs create(CommentDtoRq rq) {
    Comment comment = commentMapper.map(rq);
    comment.setBook(bookDao.findOneOrThrowException(rq.getBookId()));
    comment = commentDao.save(comment);
    return commentMapper.map(comment);
  }

  @Override
  @Transactional(readOnly = true)
  public CommentDtoRs findOne(Long id) {
    Comment comment = commentDao.findOneOrThrowException(id);
    return commentMapper.map(comment);
  }

  @Override
  public void delete(Long id) {
    commentDao.delete(id);
  }
}
