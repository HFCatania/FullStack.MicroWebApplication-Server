package com.beansbeans.moneyapp.Repositories;

import com.beansbeans.moneyapp.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserNameAndPasswordHash(String email, String password);
    User findByUserName(String username);
}
