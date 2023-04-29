package ru.otus.library.dto.book;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import ru.otus.library.dto.comment.CommentDtoRs;

@Getter
@Setter
public class FullBookDtoRs extends SimpleBookDtoRs {

  private final List<CommentDtoRs> comments = new ArrayList<>();
}
