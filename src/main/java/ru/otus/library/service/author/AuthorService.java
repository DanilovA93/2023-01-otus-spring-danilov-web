package ru.otus.library.service.author;

import java.util.List;
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.entity.Author;

public interface AuthorService {
  AuthorDtoRs save(AuthorDtoRq rq);
  AuthorDtoRs findById(String id);
  List<AuthorDtoRs> findAll();
  void delete(String id);
}
