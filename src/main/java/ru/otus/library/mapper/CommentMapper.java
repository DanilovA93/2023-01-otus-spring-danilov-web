package ru.otus.library.mapper;

import org.mapstruct.Mapper;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;
import ru.otus.library.entity.Comment;

@Mapper(
    componentModel = "spring"
)
public interface CommentMapper {
  Comment map(CommentDtoRq source);
  CommentDtoRs map(Comment source);
}
