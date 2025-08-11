package com.todoapp.todo_backend.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TaskTagMapId implements Serializable {
  private Long taskId;
  private Long tagId;

  public TaskTagMapId() {
  }

  public TaskTagMapId(Long taskId, Long tagId) {
    this.taskId = taskId;
    this.tagId = tagId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    TaskTagMapId that = (TaskTagMapId) o;
    return Objects.equals(taskId, that.taskId) && Objects.equals(tagId, that.tagId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId, tagId);
  }
  // Getters and setters

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "TaskTagMapId{" +
                "taskId=" + taskId +
                ", tagId=" + tagId +
                '}';
    }
}
