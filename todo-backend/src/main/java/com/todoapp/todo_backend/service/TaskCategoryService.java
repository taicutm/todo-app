package com.todoapp.todo_backend.service;

import com.todoapp.todo_backend.model.TaskCategory;
import com.todoapp.todo_backend.repository.TaskCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskCategoryService {
  @Autowired
  private TaskCategoryRepository taskCategoryRepository;

  public List<TaskCategory> findAll() {
    return taskCategoryRepository.findAll();
  }

  public Optional<TaskCategory> findById(Long id) {
    return taskCategoryRepository.findById(id);
  }

  public TaskCategory save(TaskCategory category) {
    return taskCategoryRepository.save(category);
  }

  public void deleteById(Long id) {
    taskCategoryRepository.deleteById(id);
  }
}
