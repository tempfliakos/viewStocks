package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.exceptions.UserAlreadyExistException;
import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import hu.elte.alkfejl.Stocks.viewStocks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user != null && password.equals(user.getPassword())){
            return user;
        }
        return null;
    }

    public User register(String email, String password){
        User user = new User(email, password);
        for(User u : userRepository.findAll()) {
            if(user.equals(u)) {
                try {
                    throw new UserAlreadyExistException();
                } catch (UserAlreadyExistException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }
}
