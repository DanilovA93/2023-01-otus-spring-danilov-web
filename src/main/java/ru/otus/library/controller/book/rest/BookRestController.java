package ru.otus.library.controller.book.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.BookDtoRs;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.dto.comment.CommentDtoRs;
import ru.otus.library.facade.book.BookFacade;
import ru.otus.library.facade.comment.CommentFacade;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {

  private final BookFacade bookFacade;
  private final CommentFacade commentFacade;

  @PostMapping
  public ResponseEntity<BookDtoRs> create(@RequestBody BookDtoRq rq) {
    return ResponseEntity.ok(bookFacade.create(rq));
  }

  @GetMapping
  public ResponseEntity<List<BookDtoRs>> findAll() {
    return ResponseEntity.ok(bookFacade.findAll());
  }

  @GetMapping("{bookId}")
  public ResponseEntity<BookDtoRs> findById(@PathVariable Long bookId) {
    return ResponseEntity.ok(bookFacade.findById(bookId));
  }

  @PutMapping("{bookId}")
  public ResponseEntity<BookDtoRs> update(
      @PathVariable Long bookId,
      @RequestBody BookDtoRq rq
  ){
    return ResponseEntity.ok(bookFacade.update(bookId, rq));
  }

  @PostMapping("{bookId}/comments")
  public ResponseEntity<CommentDtoRs> addComment(
      @PathVariable Long bookId,
      @RequestBody CommentDtoRq rq
  ){
    return ResponseEntity.ok(commentFacade.create(bookId, rq));
  }

  @DeleteMapping("{bookId}")
  public ResponseEntity<HttpStatus> delete(@PathVariable Long bookId) {
    bookFacade.delete(bookId);
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
