package ru.otus.library.dto.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class AuthorDtoRq {

  private Long id;
  private String name;

  public AuthorDtoRq(String name) {
    this.name = name;
  }
}
