package ru.otus.library.dao.comment;

import ru.otus.library.entity.Comment;

public interface CommentDao {

  Comment save(Comment comment);
  Comment findOneOrThrowException(Long id);
  void delete(Long id);
}
