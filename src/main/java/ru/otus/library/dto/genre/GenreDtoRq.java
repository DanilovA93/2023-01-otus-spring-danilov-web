package ru.otus.library.dto.genre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class GenreDtoRq {

  @JsonIgnore
  private Long id;

  private String name;

  public GenreDtoRq(String name) {
    this.name = name;
  }
}
