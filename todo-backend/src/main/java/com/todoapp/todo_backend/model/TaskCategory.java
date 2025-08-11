package com.todoapp.todo_backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
public class TaskCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private String description;

  @OneToMany(mappedBy = "taskCategory")
  @JsonManagedReference
  private List<Task> tasks;

  // Getters and setters

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TaskCategory() {
  }

  public TaskCategory(Long id, String name, String description, List<Task> tasks) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    return "TaskCategory{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", tasks=" + tasks +
        '}';
  }
}
