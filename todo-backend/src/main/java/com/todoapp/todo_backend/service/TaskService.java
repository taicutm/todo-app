package com.todoapp.todo_backend.service;

import com.todoapp.todo_backend.model.Task;
import com.todoapp.todo_backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    // lấy tất cả các task
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    // lấy task theo id
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    // tạo hoặc cập nhật task
    public Task save(Task task) {
        return taskRepository.save(task);

    }
    // xóa task theo id
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }


}
