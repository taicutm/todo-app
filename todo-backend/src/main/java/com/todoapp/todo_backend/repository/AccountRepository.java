package com.todoapp.todo_backend.repository;

import com.todoapp.todo_backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
  // Custom query methods if needed
}
