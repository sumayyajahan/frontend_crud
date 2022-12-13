package com.example.frontend_crud.repository;

import com.example.frontend_crud.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {
}
