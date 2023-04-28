package ru.otus.library.mapper;

import org.mapstruct.Mapper;
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.entity.Genre;

@Mapper(
    componentModel = "spring"
)
public interface GenreMapper {
  Genre map(GenreDtoRq source);
  GenreDtoRs map(Genre source);
}
