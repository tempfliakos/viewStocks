package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import hu.elte.alkfejl.Stocks.viewStocks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;

@Service
@SessionScope
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private User user;

    public Optional<User> login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.filter(user -> user.getPassword().equals(password));
    }

    public Optional<User> register(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(!optionalUser.isPresent()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }

}
