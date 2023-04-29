package ru.otus.library.mapper;

import org.mapstruct.Mapper;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.book.SimpleBookDtoRs;
import ru.otus.library.entity.Book;

@Mapper(
    componentModel = "spring"
)
public interface BookMapper {
  Book map(BookDtoRq source);
  SimpleBookDtoRs mapToSimple(Book source);
  FullBookDtoRs mapToFull(Book source);
}
