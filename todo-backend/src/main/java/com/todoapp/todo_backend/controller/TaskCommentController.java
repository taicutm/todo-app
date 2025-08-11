package com.todoapp.todo_backend.controller;

import com.todoapp.todo_backend.model.TaskComment;
import com.todoapp.todo_backend.service.TaskCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task-comments")
public class TaskCommentController {
  @Autowired
  private TaskCommentService taskCommentService;

  @PostMapping("/all")
  public List<TaskComment> getAll() {
    return taskCommentService.findAll();
  }

  @PostMapping("/get")
  public Optional<TaskComment> getById(@RequestBody(required = false) java.util.Map<String, Long> body) {
    if (body == null || !body.containsKey("id")) {
      throw new IllegalArgumentException("không có id trong body hoặc body là null");
    }
    Long id = body.get("id");
    return taskCommentService.findById(id);
  }

  @PostMapping
  public TaskComment create(@RequestBody TaskComment comment) {
    return taskCommentService.save(comment);
  }

  @PutMapping("/{id}")
  public TaskComment update(@PathVariable Long id, @RequestBody TaskComment comment) {
    comment.setId(id);
    return taskCommentService.save(comment);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    taskCommentService.deleteById(id);
  }
}
