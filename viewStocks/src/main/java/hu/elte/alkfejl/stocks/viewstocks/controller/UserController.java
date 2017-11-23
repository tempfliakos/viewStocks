package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import hu.elte.alkfejl.Stocks.viewStocks.service.UserService;
import hu.elte.alkfejl.Stocks.viewStocks.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody User user) {
        userService.login(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody User user) {
        userService.update(user);
    }
}
