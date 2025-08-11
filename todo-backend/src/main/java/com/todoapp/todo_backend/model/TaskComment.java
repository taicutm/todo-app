package com.todoapp.todo_backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDateTime;

@Entity
public class TaskComment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "task_id", nullable = false)
  @JsonBackReference
  private Task task;

  @ManyToOne
  @JoinColumn(name = "account_id", nullable = false)
  @JsonBackReference
  private Account account;

  @Column(nullable = false)
  private String comment;

  private LocalDateTime createdAt;

  // Getters and setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public TaskComment() {
  }

  public TaskComment(Long id, Task task, Account account, String comment, LocalDateTime createdAt) {
    this.id = id;
    this.task = task;
    this.account = account;
    this.comment = comment;
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "TaskComment{" +
        "id=" + id +
        ", task=" + task +
        ", account=" + account +
        ", comment='" + comment + '\'' +
        ", createdAt=" + createdAt +
        '}';
  }
}
