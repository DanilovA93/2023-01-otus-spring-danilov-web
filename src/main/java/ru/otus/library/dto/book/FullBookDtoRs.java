package ru.otus.library.dto.book;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.dto.comment.CommentDtoRs;
import ru.otus.library.dto.genre.GenreDtoRs;

@Getter
@Setter
@NoArgsConstructor
public class FullBookDtoRs extends SimpleBookDtoRs {

  private final List<CommentDtoRs> comments = new ArrayList<>();

  public FullBookDtoRs(
      Long id,
      String name,
      AuthorDtoRs author,
      GenreDtoRs genre
  ){
    super(id, name, author, genre);
  }
}
