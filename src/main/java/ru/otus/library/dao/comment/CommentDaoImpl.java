package ru.otus.library.dao.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.library.entity.Comment;
import ru.otus.library.repository.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentDaoImpl implements CommentDao {

  private final CommentRepository commentRepository;

  @Override
  public Comment save(Comment comment) {
    return commentRepository.save(comment);
  }

  @Override
  public Comment findOneOrThrowException(Long id) {
    if (id == null) {
      throw new RuntimeException("Comment id is null");
    }

    return commentRepository
        .findById(id)
        .orElseThrow(
            () -> new RuntimeException("Comment with id " + id + "  not found")
        );
  }

  @Override
  public void delete(Long id) {
    commentRepository.deleteById(id);
  }
}
