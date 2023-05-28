package ru.otus.library.service.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.dao.author.AuthorDao;
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.entity.Author;
import ru.otus.library.mapper.AuthorMapper;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorDao authorDao;
  private final AuthorMapper authorMapper;

  @Override
  @Transactional
  public Mono<AuthorDtoRs> save(AuthorDtoRq rq) {
    Author author = authorMapper.map(rq);
    return authorDao.save(author)
        .map(authorMapper::map);
  }

  @Override
  @Transactional(readOnly = true)
  public Mono<AuthorDtoRs> findById(String id) {
    return authorDao.findById(id)
        .map(authorMapper::map);
  }

  @Override
  @Transactional(readOnly = true)
  public Flux<AuthorDtoRs> findAll() {
    return authorDao.findAll()
        .map(authorMapper::map);
  }

  @Override
  public Mono<Void> delete(String id) {
    return authorDao.delete(id);
  }
}
