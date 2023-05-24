package ru.otus.library.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
public class Comment {

  private String text;

  public Comment(String text) {
    this.text = text;
  }
}
