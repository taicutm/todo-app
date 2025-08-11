package com.todoapp.todo_backend.service;

import com.todoapp.todo_backend.model.Account;
import com.todoapp.todo_backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
  @Autowired
  private AccountRepository accountRepository;

  public List<Account> findAll() {
    return accountRepository.findAll();
  }

  public Optional<Account> findById(Long id) {
    return accountRepository.findById(id);
  }

  public Account save(Account account) {
    return accountRepository.save(account);
  }

  public void deleteById(Long id) {
    accountRepository.deleteById(id);
  }
}
