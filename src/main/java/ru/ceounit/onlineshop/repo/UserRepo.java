package ru.ceounit.onlineshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ceounit.onlineshop.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
