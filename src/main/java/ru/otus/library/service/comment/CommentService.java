package ru.otus.library.service.comment;

import reactor.core.publisher.Mono;
import ru.otus.library.dto.comment.CommentDtoRq;

public interface CommentService {

  Mono<Void> save(CommentDtoRq rq);
}
