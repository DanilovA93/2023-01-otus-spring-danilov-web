package ru.otus.library.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.library.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
