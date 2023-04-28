//package ru.otus.library.controller.comment;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/comments")
//public class CommentController {
//
//  @PostMapping
//  public ResponseEntity<Object> create() {
//    return ResponseEntity.ok(HttpStatus.OK);
//  }
//
//  @GetMapping
//  public ResponseEntity<Object> findAll() {
//    return ResponseEntity.ok(HttpStatus.OK);
//  }
//
//  @GetMapping("{commentId}")
//  public ResponseEntity<Object> findById(@PathVariable Long commentId) {
//    return ResponseEntity.ok(commentId);
//  }
//
//  @PutMapping("{commentId}")
//  public ResponseEntity<Object> update(@PathVariable Long commentId) {
//    return ResponseEntity.ok(commentId);
//  }
//
//  @DeleteMapping("{commentId}")
//  public ResponseEntity<Object> delete(@PathVariable Long commentId) {
//    return ResponseEntity.ok(commentId);
//  }
//}
