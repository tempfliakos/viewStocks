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
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response<Object> register(@RequestParam(value = "username") String username,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "email") String email) {
        Optional<User> optionalUser = userService.register(username,password,email);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return Response.ok(user);

        }
        return Response.error("Username already used!");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response<Object> login(@RequestParam(value = "username") String username,
                                  @RequestParam(value = "password") String password){
        Optional<User> optionalUser = userService.login(username,password);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            return Response.ok(user);
        }
        return Response.error("Wrong username password pair!");
    }
}
