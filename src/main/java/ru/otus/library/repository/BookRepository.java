package ru.otus.library.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.library.entity.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
}
