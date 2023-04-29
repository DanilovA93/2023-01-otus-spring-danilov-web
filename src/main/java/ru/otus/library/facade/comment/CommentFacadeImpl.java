package ru.otus.library.facade.comment;

import java.util.List;
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
  public CommentDtoRs create(CommentDtoRq rq) {
    return commentService.create(rq);
  }

  @Override
  public List<CommentDtoRs> findAllByBookId(Long bookId) {
    return commentService.findAllByBookId(bookId);
  }

  @Override
  public void deleteById(Long commentId) {
    commentService.delete(commentId);
  }
}
