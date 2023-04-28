//package ru.otus.library.controller.author;
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
//@RequestMapping("/authors")
//public class AuthorController {
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
//  @GetMapping("{authorId}")
//  public ResponseEntity<Object> findById(@PathVariable Long authorId) {
//    return ResponseEntity.ok(authorId);
//  }
//
//  @PutMapping("{authorId}")
//  public ResponseEntity<Object> update(@PathVariable Long authorId) {
//    return ResponseEntity.ok(authorId);
//  }
//
//  @DeleteMapping("{authorId}")
//  public ResponseEntity<Object> delete(@PathVariable Long authorId) {
//    return ResponseEntity.ok(authorId);
//  }
//}
