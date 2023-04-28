package ru.otus.library.facade.genre;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.service.genre.GenreService;

@Component
@RequiredArgsConstructor
public class GenreFacadeImpl implements GenreFacade {

  private final GenreService genreService;

  @Override
  public GenreDtoRs create(GenreDtoRq rq) {
    return genreService.create(rq);
  }

  @Override
  public List<GenreDtoRs> findAll() {
    return genreService.findAll();
  }

  @Override
  public GenreDtoRs findById(Long genreId) {
    return genreService.findById(genreId);
  }

  @Override
  public void deleteById(Long genreId) {
    genreService.delete(genreId);
  }
}
