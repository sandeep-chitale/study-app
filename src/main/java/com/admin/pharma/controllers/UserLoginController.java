package com.admin.pharma.controllers;

import com.admin.pharma.enums.UserType;
import com.admin.pharma.exception.UserAlreadyExistsException;
import com.admin.pharma.model.User;
import com.admin.pharma.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
//import javax.validation.Valid;
import java.util.List;
/**
 * Created by DELL on 11/29/2015.
 */

@RestController
public class UserLoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
    private final UserService userService;

    @Autowired
    public UserLoginController(final UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean createUser(@RequestBody  final User user) {
        LOGGER.debug("Received request to create the {}", user);
        return userService.save(user);
    }
    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> listUsers() {
        LOGGER.debug("Received request to list all users");
        return userService.getList();
    }
    @CrossOrigin
    @RequestMapping(value = "/greet", method = RequestMethod.GET, produces = "text/html")
    private String greet() {
        return "Hello World!";
    }

    @CrossOrigin
    @RequestMapping(value = "/checkID", method = RequestMethod.GET, produces = "application/json")
    private boolean checkID(@RequestParam final String id) {
        return  userService.validateID(id);
    }

    @CrossOrigin
    @RequestMapping(path = "/getUser", method = RequestMethod.GET, produces = "application/json")
    private User getUser(@RequestParam final String id) {
        return  userService.getUser(id);
    }

//    @CrossOrigin
//    @RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = "application/json")
//    private User getUser(@RequestParam final String id) {
//        return  userService.getUser(id);
//    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return e.getMessage();
    }

}
