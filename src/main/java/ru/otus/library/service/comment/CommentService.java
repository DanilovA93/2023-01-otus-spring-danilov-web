package ru.otus.library.service.comment;

import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;

public interface CommentService {

  CommentDtoRs create(CommentDtoRq rq);
  CommentDtoRs findOne(Long id);
  void delete(Long id);
}
