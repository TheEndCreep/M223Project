package ch.zli.finalproject.User;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;

public interface UserService {
    String login(String name, String password);
    Optional<User> findByToken(String token);
    AppUser findById(Long id);
}
