package ru.otus.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.library.entity.Author;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Comment;
import ru.otus.library.entity.Genre;
import ru.otus.library.repository.AuthorRepository;
import ru.otus.library.repository.BookRepository;
import ru.otus.library.repository.GenreRepository;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Application.class);
    insertToDB(context);
  }

  private static void insertToDB(ApplicationContext context) {
    AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
    GenreRepository genreRepository = context.getBean(GenreRepository.class);
    BookRepository bookRepository = context.getBean(BookRepository.class);

    Author author = authorRepository.save(new Author("Init Author"));
    Genre genre = genreRepository.save(new Genre("Init Genre"));
    Book book = bookRepository.save(new Book("Init Book", author, genre));

    book.addComment(new Comment("Init Comment №1"));
    book.addComment(new Comment("Init Comment №2"));
    bookRepository.save(book);
  }
}
