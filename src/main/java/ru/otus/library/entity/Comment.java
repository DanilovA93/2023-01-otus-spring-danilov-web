package ru.otus.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "comments")
public class Comment {

  @Id
  @SequenceGenerator(
      name = "comment_sequence",
      sequenceName = "comment_sequence"
  )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_sequence")
  @Column(name = "id")
  private Long id;

  @Column(name = "text", nullable = false)
  private String text;

  @ManyToOne
  @JoinColumn(name = "book_id", nullable = false)
  @Fetch(FetchMode.JOIN)
  private Book book;
}
