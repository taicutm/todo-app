package com.todoapp.todo_backend.controller;

import com.todoapp.todo_backend.model.TaskTag;
import com.todoapp.todo_backend.service.TaskTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task-tags")
public class TaskTagController {
  @Autowired
  private TaskTagService taskTagService;

  @PostMapping("/all")
  public List<TaskTag> getAll() {
    return taskTagService.findAll();
  }

  @PostMapping("/get")
  public Optional<TaskTag> getById(@RequestBody(required = false) java.util.Map<String, Long> body) {
    if (body == null || !body.containsKey("id")) {
      throw new IllegalArgumentException("không có id trong body hoặc body là null");
    }
    Long id = body.get("id");
    return taskTagService.findById(id);
  }

  @PostMapping
  public TaskTag create(@RequestBody TaskTag tag) {
    return taskTagService.save(tag);
  }

  @PutMapping("/{id}")
  public TaskTag update(@PathVariable Long id, @RequestBody TaskTag tag) {
    tag.setId(id);
    return taskTagService.save(tag);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    taskTagService.deleteById(id);
  }
}
