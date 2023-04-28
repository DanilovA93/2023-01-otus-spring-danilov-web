package ru.otus.library.facade.author;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.service.author.AuthorService;

@Component
@RequiredArgsConstructor
public class AuthorFacadeImpl implements AuthorFacade {

  private final AuthorService authorService;

  @Override
  public AuthorDtoRs create(AuthorDtoRq rq) {
    return authorService.create(rq);
  }

  @Override
  public List<AuthorDtoRs> findAll() {
    return authorService.findAll();
  }

  @Override
  public AuthorDtoRs findById(Long id) {
    return authorService.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    authorService.delete(id);
  }
}
