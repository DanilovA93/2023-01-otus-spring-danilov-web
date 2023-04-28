package ru.otus.library.dto.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class BookDtoRq {

  @JsonIgnore
  private Long id;

  private Long authorId;
  private Long genreId;
  private String name;

  public BookDtoRq(
      Long authorId,
      Long genreId,
      String name
  ){
    this.authorId = authorId;
    this.genreId = genreId;
    this.name = name;
  }
}
