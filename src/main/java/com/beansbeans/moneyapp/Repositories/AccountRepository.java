package com.beansbeans.moneyapp.Repositories;

import com.beansbeans.moneyapp.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Iterable<Account> findAllByUserIdIs(Long userId);
}
