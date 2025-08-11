package com.todoapp.todo_backend.controller;

import com.todoapp.todo_backend.model.Account;
import com.todoapp.todo_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
  @Autowired
  private AccountService accountService;

  @PostMapping("/all")
  public List<Account> getAll() {
    return accountService.findAll();
  }

  @PostMapping("/get")
  public Optional<Account> getById(@RequestBody(required = false) Map<String, Long> body) {
    if (body == null || !body.containsKey("id")) {
      throw new IllegalArgumentException("không có id trong body hoặc body là null");
    }
    Long id = body.get("id");
    return accountService.findById(id);
  }

  @PostMapping
  public Account create(@RequestBody Account account) {
    return accountService.save(account);
  }

  @PutMapping("/{id}")
  public Account update(@PathVariable Long id, @RequestBody Account account) {
    account.setId(id);
    return accountService.save(account);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    accountService.deleteById(id);
  }
}
