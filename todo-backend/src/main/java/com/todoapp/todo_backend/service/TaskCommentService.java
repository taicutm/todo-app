package com.todoapp.todo_backend.service;

import com.todoapp.todo_backend.model.TaskComment;
import com.todoapp.todo_backend.repository.TaskCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskCommentService {
  @Autowired
  private TaskCommentRepository taskCommentRepository;

  public List<TaskComment> findAll() {
    return taskCommentRepository.findAll();
  }

  public Optional<TaskComment> findById(Long id) {
    return taskCommentRepository.findById(id);
  }

  public TaskComment save(TaskComment comment) {
    return taskCommentRepository.save(comment);
  }

  public void deleteById(Long id) {
    taskCommentRepository.deleteById(id);
  }
}
