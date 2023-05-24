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
  private String id;

  private String authorId;
  private String genreId;
  private String name;

  public BookDtoRq(
      String authorId,
      String genreId,
      String name
  ){
    this.authorId = authorId;
    this.genreId = genreId;
    this.name = name;
  }
}
