package hu.elte.alkfejl.Stocks.viewStocks.service;

import hu.elte.alkfejl.Stocks.viewStocks.exception.UserAlreadyExistException;
import hu.elte.alkfejl.Stocks.viewStocks.exception.WrongUserAndPasswordPairException;
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

    public User login(String name, String password) {
        try {
            User user = userRepository.findByName(name);
            if(!user.equals(Optional.empty()) && password.equals(user.getPassword())){
                return user;
            } else {
                throw new WrongUserAndPasswordPairException();
            }
        } catch (WrongUserAndPasswordPairException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public User register(String name, String password){
        User user = new User(name, password);
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
