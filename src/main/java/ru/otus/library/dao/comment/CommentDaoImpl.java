package ru.otus.library.dao.comment;

import java.util.List;
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
  public List<Comment> findAllByBookId(Long bookId) {
    return commentRepository.findAllByBookId(bookId);
  }

  @Override
  public void delete(Long id) {
    commentRepository.deleteById(id);
  }
}
