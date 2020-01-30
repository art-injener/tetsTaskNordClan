package ru.art.testTaskNordClan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.art.testTaskNordClan.model.User;

/**
 * interface for receiving data from the JPA
 * @author Danilchenko Artem
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String s);
}
