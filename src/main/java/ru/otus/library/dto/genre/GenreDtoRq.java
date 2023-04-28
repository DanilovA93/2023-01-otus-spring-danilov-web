package ru.otus.library.dto.genre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDtoRq {

  @JsonIgnore
  private Long id;

  private String name;
}
