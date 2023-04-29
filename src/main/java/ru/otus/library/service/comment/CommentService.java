package ru.otus.library.service.comment;

import java.util.List;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;

public interface CommentService {

  CommentDtoRs create(CommentDtoRq rq);
  List<CommentDtoRs> findAllByBookId(Long bookId);
  void delete(Long id);
}
