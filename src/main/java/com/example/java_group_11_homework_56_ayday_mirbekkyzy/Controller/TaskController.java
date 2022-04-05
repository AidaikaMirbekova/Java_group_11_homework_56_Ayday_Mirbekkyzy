package com.example.java_group_11_homework_56_ayday_mirbekkyzy.Controller;

import com.example.java_group_11_homework_56_ayday_mirbekkyzy.DTO.TaskDTO;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.DTO.TaskInDTO;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity.User;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Service.TaskService;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/addNewTask")
    public ResponseEntity<String> createTask(Authentication authentication,@RequestBody TaskInDTO taskDTO) {
        User user = (User) authentication.getPrincipal();
        taskService.createTask(user.getUsername(), taskDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/changeTypeOfTask")
    public ResponseEntity<Void> changeType(@RequestParam Long taskId, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        taskService.changeTaskType(taskId, user.getUsername());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/showAllTasks")
    public Slice<TaskDTO> show(Authentication auth){
        User user = (User) auth.getPrincipal();
        return taskService.showAllTasks(user.getUsername());
    }

    @GetMapping("/showOneTask")
    public TaskInDTO showOne(@RequestParam Long taskId){
        return taskService.showOneTask(taskId);
    }

}
