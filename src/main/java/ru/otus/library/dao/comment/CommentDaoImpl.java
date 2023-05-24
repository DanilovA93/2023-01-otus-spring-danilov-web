package ru.otus.library.dao.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.library.entity.Comment;

@Service
@RequiredArgsConstructor
public class CommentDaoImpl implements CommentDao {

//  private final CommentRepository commentRepository;

  @Override
  public Comment save(Comment comment) {
    return null;// commentRepository.save(comment);
  }

  @Override
  public void delete(String id) {
//    commentRepository.deleteById(id);
  }
}
