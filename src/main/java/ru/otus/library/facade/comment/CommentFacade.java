package ru.otus.library.facade.comment;

import java.util.List;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;

public interface CommentFacade {

  CommentDtoRs create(CommentDtoRq rq);
  List<CommentDtoRs> findAllByBookId(Long bookId);
  void deleteById(Long commentId);
}
