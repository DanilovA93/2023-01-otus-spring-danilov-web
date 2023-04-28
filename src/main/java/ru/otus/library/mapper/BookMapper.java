package ru.otus.library.mapper;

import org.mapstruct.Mapper;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.BookDtoRs;
import ru.otus.library.entity.Book;

@Mapper(
    componentModel = "spring"
)
public interface BookMapper {
  Book map(BookDtoRq source);
  BookDtoRs map(Book source);
}
