package ru.otus.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.entity.Author;

@Mapper(
    componentModel = "spring"
)
public interface AuthorMapper {

  @Mapping(target = "name", source = "name")
  Author map(AuthorDtoRq source);
  AuthorDtoRs map(Author source);
}
