package ru.otus.library.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "books")
public class Book {

  @Id
  @SequenceGenerator(
      name = "author_sequence",
      sequenceName = "author_sequence"
  )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "author_id", nullable = false)
  @Fetch(FetchMode.JOIN)
  private Author author;

  @ManyToOne
  @JoinColumn(name = "genre_id", nullable = false)
  @Fetch(FetchMode.JOIN)
  private Genre genre;

  @OneToMany(mappedBy = "book", orphanRemoval = true)
  private final List<Comment> comments = new ArrayList<>();
}
