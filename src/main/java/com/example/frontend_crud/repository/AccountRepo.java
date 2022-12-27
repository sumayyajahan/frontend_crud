package com.example.frontend_crud.repository;

import com.example.frontend_crud.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Integer> {

    List<Account> findByOrderByBalanceDesc();
    List<Account> findAllByBalanceGreaterThan(Integer amount);
}
