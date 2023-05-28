package ru.otus.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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
  public Mono<FullBookDtoRs> findOne(@PathVariable String id) {
    return bookService.findById(id);
  }

  @GetMapping
  public Flux<SimpleBookDtoRs> findAll() {
    return bookService.findAll();
  }

  @PostMapping
  public Mono<SimpleBookDtoRs> save(BookDtoRq rq) {
    return bookService.save(rq);
  }

  @DeleteMapping("{id}")
  public Mono<Void> delete(@PathVariable String id){
    return bookService.delete(id);
  }
}
