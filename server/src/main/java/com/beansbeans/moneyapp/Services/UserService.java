package com.beansbeans.moneyapp.Services;

import com.beansbeans.moneyapp.Model.User;
import com.beansbeans.moneyapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User rawUser){
        User savedUser = new User(rawUser, ValidateUserNamePassword.makeHash(rawUser.getPasswordHash()));
        return userRepository.save(savedUser);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User show(Long id){
        return userRepository.findById(id).get();
    }


    public User updateUser(Long id, User newUserData){
        User originalUser = userRepository.findById(id).get();
        originalUser.setFirstName(newUserData.getFirstName());
        originalUser.setLastName(newUserData.getLastName());
        return userRepository.save(originalUser);
    }

    public Boolean deleteUser(Long id){
       userRepository.deleteById(id);
       return true;
    }

    public User login(User user) throws SQLException{
        User foundUser = userRepository.findByUserName(user.getUserName());
        if(foundUser == null) throw new SQLException();
        if(ValidateUserNamePassword.confirmPasswordHash(
                user.getPasswordHash(), foundUser.getPasswordHash())){
            return foundUser;
        } else {
            throw new SQLException();
        }
    }
}
