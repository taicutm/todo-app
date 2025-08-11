package com.todoapp.todo_backend.controller;

import com.todoapp.todo_backend.model.Task;
import com.todoapp.todo_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") // Cho phép gọi API từ bất kỳ frontend nào
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Lấy tất cả tasks
    @PostMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/get")
    public Task getTaskById(@RequestBody Map<String, Long> body) {
        if (body == null || !body.containsKey("id")) {
            throw new IllegalArgumentException("không có id trong body hoặc body là null");
        }
        Long id = body.get("id");
        return taskService.findById(id);
    }

    // Tạo hoặc cập nhật task (nếu có id thì là update)
    @PostMapping("/save")
    public Task saveTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    // Xoá task theo id
    @PostMapping("/delete")
    public void deleteTaskById(@RequestBody Map<String, Long> body) {
        Long id = body.get("id");
        if (id == null) {
            throw new IllegalArgumentException("ID không được cung cấp");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID phải lớn hơn 0");
        }
        taskService.deleteById(id);
    }
}
