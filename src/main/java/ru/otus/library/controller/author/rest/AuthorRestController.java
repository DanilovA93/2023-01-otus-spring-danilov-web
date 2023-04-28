package ru.otus.library.controller.author.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.facade.author.AuthorFacade;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorRestController {

  private final AuthorFacade authorFacade;

  @PostMapping
  public ResponseEntity<AuthorDtoRs> create(
      @RequestBody AuthorDtoRq rq
  ){
    return ResponseEntity.ok(authorFacade.create(rq));
  }

  @GetMapping
  public ResponseEntity<List<AuthorDtoRs>> findAll() {
    return ResponseEntity.ok(authorFacade.findAll());
  }

  @GetMapping("{authorId}")
  public ResponseEntity<AuthorDtoRs> findById(
      @PathVariable Long authorId
  ){
    return ResponseEntity.ok(authorFacade.findById(authorId));
  }

  @DeleteMapping("{authorId}")
  public ResponseEntity<HttpStatus> deleteById(
      @PathVariable Long authorId
  ){
    authorFacade.deleteById(authorId);
    return ResponseEntity.ok(HttpStatus.OK);
  }
}