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

    public User login(User user) {
        return userRepository.findByEmail(user.getEmail());
    }

    public User register(User user){
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
