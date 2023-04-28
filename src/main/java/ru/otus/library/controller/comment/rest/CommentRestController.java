package ru.otus.library.controller.comment.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.library.dto.comment.CommentDtoRs;
import ru.otus.library.facade.comment.CommentFacade;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentRestController {

  private final CommentFacade commentFacade;

  @GetMapping("{commentId}")
  public ResponseEntity<CommentDtoRs> findById(
      @PathVariable Long commentId
  ){
    return ResponseEntity.ok(commentFacade.findById(commentId));
  }

  @DeleteMapping("{commentId}")
  public ResponseEntity<HttpStatus> deleteById(
      @PathVariable Long commentId
  ){
    commentFacade.deleteById(commentId);
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
