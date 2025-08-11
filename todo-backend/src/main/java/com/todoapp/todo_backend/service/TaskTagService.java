package com.todoapp.todo_backend.service;

import com.todoapp.todo_backend.model.TaskTag;
import com.todoapp.todo_backend.repository.TaskTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskTagService {
  @Autowired
  private TaskTagRepository taskTagRepository;

  public List<TaskTag> findAll() {
    return taskTagRepository.findAll();
  }

  public Optional<TaskTag> findById(Long id) {
    return taskTagRepository.findById(id);
  }

  public TaskTag save(TaskTag tag) {
    return taskTagRepository.save(tag);
  }

  public void deleteById(Long id) {
    taskTagRepository.deleteById(id);
  }
}
