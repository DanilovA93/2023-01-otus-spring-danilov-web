package ru.otus.library.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.dto.book.FullBookDtoRs;
import ru.otus.library.dto.book.SimpleBookDtoRs;
import ru.otus.library.service.book.BookService;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("{id}")
  public ResponseEntity<FullBookDtoRs> findOne(@PathVariable String id) {
    return ResponseEntity.ok(bookService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<SimpleBookDtoRs>> findAll() {
    return ResponseEntity.ok(bookService.findAll());
  }

  @PostMapping
  public ResponseEntity<SimpleBookDtoRs> save(BookDtoRq rq) {
    return ResponseEntity.ok(bookService.save(rq));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<HttpStatus> delete(@PathVariable String id){
    bookService.delete(id);
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
