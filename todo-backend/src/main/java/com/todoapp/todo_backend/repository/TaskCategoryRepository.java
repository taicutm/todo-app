package com.todoapp.todo_backend.repository;

import com.todoapp.todo_backend.model.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {
}
