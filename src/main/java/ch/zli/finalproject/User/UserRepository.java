package ch.zli.finalproject.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u where u.name = ?1 and u.password = ?2 ")
    Optional login(String name, String password);
    Optional findByToken (String token);
}
