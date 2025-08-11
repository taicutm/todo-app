package com.todoapp.todo_backend.controller;

import com.todoapp.todo_backend.model.TaskTagMap;
import com.todoapp.todo_backend.model.TaskTagMapId;
import com.todoapp.todo_backend.service.TaskTagMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task-tag-maps")
public class TaskTagMapController {
  @Autowired
  private TaskTagMapService taskTagMapService;

  @PostMapping("/all")
  public List<TaskTagMap> getAll() {
    return taskTagMapService.findAll();
  }

  @PostMapping("/get")
  public Optional<TaskTagMap> getById(@RequestBody(required = false) java.util.Map<String, Long> body) {
    if (body == null || !body.containsKey("taskId") || !body.containsKey("tagId")) {
      throw new IllegalArgumentException("không có taskId hoặc tagId trong body hoặc body là null");
    }
    Long taskId = body.get("taskId");
    Long tagId = body.get("tagId");
    return taskTagMapService.findById(new TaskTagMapId(taskId, tagId));
  }

  @PostMapping
  public TaskTagMap create(@RequestBody TaskTagMap map) {
    return taskTagMapService.save(map);
  }

  @DeleteMapping("/{taskId}/{tagId}")
  public void delete(@PathVariable Long taskId, @PathVariable Long tagId) {
    taskTagMapService.deleteById(new TaskTagMapId(taskId, tagId));
  }
}
