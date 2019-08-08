package com.beansbeans.moneyapp.Controllers;

import com.beansbeans.moneyapp.Model.User;
import com.beansbeans.moneyapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
@RequestMapping(path= "/api")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<User> create(@RequestBody User user){
        try {
            return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/users/login")
    public ResponseEntity<User> login(@RequestBody User user){
        try {
            return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(user, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Iterable<User>> findAll(){
        try {
            return new ResponseEntity<Iterable<User>>(userService.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(userService.show(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUserInfo(@PathVariable Long id, @RequestBody User user){
        try {
            return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        try {
            return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
