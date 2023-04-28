package ru.otus.library.facade.author;

import java.util.List;
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;

public interface AuthorFacade {

  AuthorDtoRs create(AuthorDtoRq rq);
  List<AuthorDtoRs> findAll();
  AuthorDtoRs findById(Long id);
  void deleteById(Long id);
}
