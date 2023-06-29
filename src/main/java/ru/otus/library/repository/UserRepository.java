package ru.otus.library.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.library.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
