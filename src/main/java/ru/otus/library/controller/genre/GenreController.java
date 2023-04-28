//package ru.otus.library.controller.genre;
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
//@RequestMapping("/genres")
//public class GenreController {
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
//  @GetMapping("{genreId}")
//  public ResponseEntity<Object> findById(@PathVariable Long genreId) {
//    return ResponseEntity.ok(genreId);
//  }
//
//  @PutMapping("{genreId}")
//  public ResponseEntity<Object> update(@PathVariable Long genreId) {
//    return ResponseEntity.ok(genreId);
//  }
//
//  @DeleteMapping("{genreId}")
//  public ResponseEntity<Object> delete(@PathVariable Long genreId) {
//    return ResponseEntity.ok(genreId);
//  }
//}
