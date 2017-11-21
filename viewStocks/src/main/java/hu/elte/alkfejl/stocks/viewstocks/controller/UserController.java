package hu.elte.alkfejl.Stocks.viewStocks.controller;

import hu.elte.alkfejl.Stocks.viewStocks.model.User;
import hu.elte.alkfejl.Stocks.viewStocks.service.UserService;
import hu.elte.alkfejl.Stocks.viewStocks.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private User user;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response<Object> register(@RequestParam(value = "email") String email,
                                     @RequestParam(value = "password") String password) {
        Optional<User> optionalUser = userService.register(email, password);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            return Response.ok(user);

        }
        return Response.error("Username already used!");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response<Object> login(@RequestParam(value = "email") String email,
                                  @RequestParam(value = "password") String password) {
        Optional<User> optionalUser = userService.login(email, password);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            return Response.ok(user);
        }
        return Response.error("Wrong username password pair!");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Response<Object> update(@RequestParam(value = "email") String email,
                                   @RequestParam(value = "password") String password) {
        Optional<User> optionalUser = userService.update(email,password);
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
            return Response.ok(user);
        }
        return Response.error("Can't modify!");
    }
}
