package com.todoapp.todo_backend.repository;

import com.todoapp.todo_backend.model.TaskComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Long> {
}
