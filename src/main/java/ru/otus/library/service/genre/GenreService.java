package ru.otus.library.service.genre;

import java.util.List;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;

public interface GenreService {
  GenreDtoRs save(GenreDtoRq rq);
  GenreDtoRs findById(String id);
  List<GenreDtoRs> findAll();
  void delete(String id);
}
