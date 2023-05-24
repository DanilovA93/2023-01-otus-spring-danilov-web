package ru.otus.library.service.comment;

import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;

public interface CommentService {

  CommentDtoRs save(CommentDtoRq rq);
  void delete(String id);
}
