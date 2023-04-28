package ru.otus.library.facade.comment;

import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;

public interface CommentFacade {

  CommentDtoRs create(Long bookId, CommentDtoRq rq);
  CommentDtoRs findById(Long commentId);
  void deleteById(Long commentId);
}
