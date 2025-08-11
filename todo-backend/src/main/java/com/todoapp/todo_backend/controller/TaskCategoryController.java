package com.todoapp.todo_backend.controller;

import com.todoapp.todo_backend.model.TaskCategory;
import com.todoapp.todo_backend.service.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task-categories")
public class TaskCategoryController {
  @Autowired
  private TaskCategoryService taskCategoryService;

  @PostMapping("/all")
  public List<TaskCategory> getAll() {
    return taskCategoryService.findAll();
  }

  @PostMapping("/get")
  public Optional<TaskCategory> getById(@RequestBody(required = false) java.util.Map<String, Long> body) {
    if (body == null || !body.containsKey("id")) {
      throw new IllegalArgumentException("không có id trong body hoặc body là null");
    }
    Long id = body.get("id");
    return taskCategoryService.findById(id);
  }

  @PostMapping
  public TaskCategory create(@RequestBody TaskCategory category) {
    return taskCategoryService.save(category);
  }

  @PutMapping("/{id}")
  public TaskCategory update(@PathVariable Long id, @RequestBody TaskCategory category) {
    category.setId(id);
    return taskCategoryService.save(category);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    taskCategoryService.deleteById(id);
  }
}
