package ru.otus.library.dao.comment;

import java.util.List;
import ru.otus.library.entity.Comment;

public interface CommentDao {

  Comment save(Comment comment);
  void delete(Long id);
}
