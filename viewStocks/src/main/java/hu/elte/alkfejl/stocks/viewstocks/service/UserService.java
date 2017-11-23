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

    public void login(User user) {
        userRepository.findOne(10L);
    }

    public void register(User user){
        for(User u: userRepository.findAll()) {
            if(user.equals(u)) {
                try {
                    throw new UserAlreadyExistException();
                } catch (UserAlreadyExistException ex) {
                    ex.printStackTrace();
                }
            }
        }
        userRepository.save(user);
    }

    public void update(User user) {
        userRepository.save(user);
    }
}
