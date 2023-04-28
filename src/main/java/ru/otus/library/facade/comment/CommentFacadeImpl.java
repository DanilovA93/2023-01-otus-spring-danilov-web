package ru.otus.library.facade.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;
import ru.otus.library.service.comment.CommentService;

@Component
@RequiredArgsConstructor
public class CommentFacadeImpl implements CommentFacade {

  private final CommentService commentService;

  @Override
  public CommentDtoRs create(Long bookId, CommentDtoRq rq) {
    rq.setBookId(bookId);
    return commentService.create(rq);
  }

  @Override
  public CommentDtoRs findById(Long commentId) {
    return commentService.findOne(commentId);
  }

  @Override
  public void deleteById(Long commentId) {
    commentService.delete(commentId);
  }
}
