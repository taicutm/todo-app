package com.todoapp.todo_backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "task_tag_map")
public class TaskTagMap {
  @EmbeddedId
  private TaskTagMapId id;

  @ManyToOne
  @MapsId("taskId")
  @JoinColumn(name = "task_id")
  @JsonBackReference
  private Task task;

  @ManyToOne
  @MapsId("tagId")
  @JoinColumn(name = "tag_id")
  @JsonBackReference
  private TaskTag tag;

  // Getters and setters

  public TaskTagMapId getId() {
    return id;
  }

  public void setId(TaskTagMapId id) {
    this.id = id;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  public TaskTag getTag() {
    return tag;
  }

  public void setTag(TaskTag tag) {
    this.tag = tag;
  }

  public TaskTagMap() {
  }

  public TaskTagMap(TaskTagMapId id, Task task, TaskTag tag) {
    this.id = id;
    this.task = task;
    this.tag = tag;
  }

  @Override
  public String toString() {
    return "TaskTagMap{" +
        "id=" + id +
        ", task=" + task +
        ", tag=" + tag +
        '}';
  }
}
