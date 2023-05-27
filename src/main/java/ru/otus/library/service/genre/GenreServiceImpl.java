package ru.otus.library.service.genre;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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
  public Mono<GenreDtoRs> save(GenreDtoRq rq) {
    Genre genre = genreMapper.map(rq);
    return genreDao.save(genre)
        .map(genreMapper::map);
  }

  @Override
  @Transactional(readOnly = true)
  public Mono<GenreDtoRs> findById(String id) {
    return genreDao.findById(id)
        .map(genreMapper::map);
  }

  @Override
  @Transactional(readOnly = true)
  public Flux<GenreDtoRs> findAll() {
    return genreDao.findAll()
        .map(genreMapper::map);
  }

  @Override
  public Mono<Void> delete(String id) {
    return genreDao.delete(id);
  }
}
