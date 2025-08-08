package com.todoapp.todo_backend.repository;

import com.todoapp.todo_backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
