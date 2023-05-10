package ru.otus.library.dto.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.dto.genre.GenreDtoRs;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SimpleBookDtoRs {

  private Long id;
  private String name;
  private AuthorDtoRs author;
  private GenreDtoRs genre;
}
