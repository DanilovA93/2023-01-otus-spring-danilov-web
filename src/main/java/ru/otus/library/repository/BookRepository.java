package ru.otus.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
