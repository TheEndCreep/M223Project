package ch.zli.finalproject.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    @Query(value = "SELECT u FROM AppUser u where u.name = ?1 and u.password = ?2 ")
    Optional<AppUser> login(String name, String password);
    Optional<AppUser> findByToken (String token);
}
