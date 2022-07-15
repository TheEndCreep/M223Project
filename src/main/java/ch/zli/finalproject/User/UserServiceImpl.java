package ch.zli.finalproject.User;

import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserRepository userRepository;

    @Override
    public String login(String name, String password){
        Optional<AppUser> appUser = userRepository.login(name, password);
        if(appUser.isPresent()){
            String token = UUID.randomUUID().toString();
            AppUser u = appUser.get();
            u.setToken(token);
            userRepository.save(u);
            return token;
        }
        return StringUtils.EMPTY;
    }

    @Override
    public Optional<User> findByToken(String token) {
        Optional<AppUser> appUser = userRepository.findByToken(token);
        if(appUser.isPresent()){
            AppUser u = appUser.get();
            User user = new User(u.getName(), u.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public AppUser findById(Long id){
        Optional<AppUser> appUser = userRepository.findById(id);
        return appUser.orElse(null);
    }

}
