package ru.otus.library.dto.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDtoRq {

  private Long bookId;
  private String text;
}
