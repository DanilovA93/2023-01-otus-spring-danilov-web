package ru.otus.library.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.otus.library.entity.Author;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {

//  Mono<Author> save(Mono<Author> person);
}
