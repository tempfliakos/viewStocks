package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import hu.elte.alkfejl.Stocks.viewStocks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password ) {
        return userService.register(email, password);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestParam String email,
                      @RequestParam String password ) {
        return userService.login(email, password);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
}
