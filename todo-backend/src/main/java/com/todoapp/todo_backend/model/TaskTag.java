package com.todoapp.todo_backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
public class TaskTag {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "tag")
  @JsonManagedReference
  private List<TaskTagMap> taskTagMaps;

  // Getters and setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<TaskTagMap> getTaskTagMaps() {
    return taskTagMaps;
  }

  public void setTaskTagMaps(List<TaskTagMap> taskTagMaps) {
    this.taskTagMaps = taskTagMaps;
  }

  public TaskTag() {
  }

  public TaskTag(Long id, String name, List<TaskTagMap> taskTagMaps) {
    this.id = id;
    this.name = name;
    this.taskTagMaps = taskTagMaps;
  }

  @Override
  public String toString() {
    return "TaskTag{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", taskTagMaps=" + taskTagMaps +
        '}';
  }
}
