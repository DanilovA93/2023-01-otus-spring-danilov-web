package ru.otus.library.service.author;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
  public AuthorDtoRs save(AuthorDtoRq rq) {
    Author author = authorMapper.map(rq);
    authorDao.save(author);
    return authorMapper.map(author);
  }

  @Override
  @Transactional(readOnly = true)
  public AuthorDtoRs findById(String id) {
    Author author = authorDao.findOneOrThrowException(id);
    return authorMapper.map(author);
  }

  @Override
  @Transactional(readOnly = true)
  public List<AuthorDtoRs> findAll() {
    return authorDao.findAll().stream()
        .map(authorMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(String id) {
    authorDao.delete(id);
  }
}
