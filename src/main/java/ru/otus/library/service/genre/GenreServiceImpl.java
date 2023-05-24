package ru.otus.library.service.genre;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dao.genre.GenreDao;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.entity.Genre;
import ru.otus.library.mapper.GenreMapper;

@Component
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

  private final GenreDao genreDao;
  private final GenreMapper genreMapper;

  @Override
  @Transactional
  public GenreDtoRs save(GenreDtoRq rq) {
    Genre genre = genreMapper.map(rq);
    genreDao.save(genre);
    return genreMapper.map(genre);
  }

  @Override
  @Transactional(readOnly = true)
  public GenreDtoRs findById(String id) {
    Genre genre = genreDao.findOneOrThrowException(id);
    return genreMapper.map(genre);
  }

  @Override
  @Transactional(readOnly = true)
  public List<GenreDtoRs> findAll() {
    return genreDao.findAll().stream()
        .map(genreMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(String id) {
    genreDao.delete(id);
  }
}
