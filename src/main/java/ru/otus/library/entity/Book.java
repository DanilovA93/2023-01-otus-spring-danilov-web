package ru.otus.library.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document("books")
public class Book {

  @Id
  private String id;

  private String name;

  @DBRef
  private Author author;

  @DBRef
  private Genre genre;

//  @DocumentReference
  @Setter(AccessLevel.PRIVATE)
  private List<Comment> comments = new ArrayList<>();

  public Book(String name, Author author, Genre genre) {
    this.name = name;
    this.author = author;
    this.genre = genre;
  }

  public void addComment(Comment comment) {
    this.comments.add(comment);
  }
}