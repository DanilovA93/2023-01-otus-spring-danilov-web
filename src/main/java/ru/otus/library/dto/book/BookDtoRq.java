package ru.otus.library.dto.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDtoRq {

  @JsonIgnore
  private Long id;

  private Long authorId;
  private Long genreId;
  private String name;
}
