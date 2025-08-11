package com.todoapp.todo_backend.repository;

import com.todoapp.todo_backend.model.TaskTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTagRepository extends JpaRepository<TaskTag, Long> {
}
