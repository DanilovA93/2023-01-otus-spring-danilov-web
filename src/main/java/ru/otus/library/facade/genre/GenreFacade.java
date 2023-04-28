package ru.otus.library.facade.genre;

import java.util.List;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;

public interface GenreFacade {

  GenreDtoRs create(GenreDtoRq rq);
  List<GenreDtoRs> findAll();
  GenreDtoRs findById(Long genreId);
  void deleteById(Long genreId);
}
