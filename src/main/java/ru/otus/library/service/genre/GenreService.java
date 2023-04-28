package ru.otus.library.service.genre;

import java.util.List;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;

public interface GenreService {
  GenreDtoRs create(GenreDtoRq rq);
  GenreDtoRs findById(Long id);
  List<GenreDtoRs> findAll();
  void delete(Long id);
}
