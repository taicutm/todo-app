package com.todoapp.todo_backend.repository;

import com.todoapp.todo_backend.model.TaskTagMap;
import com.todoapp.todo_backend.model.TaskTagMapId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTagMapRepository extends JpaRepository<TaskTagMap, TaskTagMapId> {
}
