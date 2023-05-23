package ru.otus.library.controller;

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
import ru.otus.library.service.author.AuthorService;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorService authorService;

  @PostMapping
  public ResponseEntity<AuthorDtoRs> create(@RequestBody AuthorDtoRq rq) {
    return ResponseEntity.ok(authorService.save(rq));
  }

  @GetMapping
  public ResponseEntity<List<AuthorDtoRs>> findAll() {
    return ResponseEntity.ok(authorService.findAll());
  }

  @DeleteMapping("{id}")
  public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
    authorService.delete(id);
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
