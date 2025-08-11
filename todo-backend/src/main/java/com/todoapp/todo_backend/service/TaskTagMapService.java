package com.todoapp.todo_backend.service;

import com.todoapp.todo_backend.model.TaskTagMap;
import com.todoapp.todo_backend.model.TaskTagMapId;
import com.todoapp.todo_backend.repository.TaskTagMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskTagMapService {
  @Autowired
  private TaskTagMapRepository taskTagMapRepository;

  public List<TaskTagMap> findAll() {
    return taskTagMapRepository.findAll();
  }

  public Optional<TaskTagMap> findById(TaskTagMapId id) {
    return taskTagMapRepository.findById(id);
  }

  public TaskTagMap save(TaskTagMap map) {
    return taskTagMapRepository.save(map);
  }

  public void deleteById(TaskTagMapId id) {
    taskTagMapRepository.deleteById(id);
  }
}
