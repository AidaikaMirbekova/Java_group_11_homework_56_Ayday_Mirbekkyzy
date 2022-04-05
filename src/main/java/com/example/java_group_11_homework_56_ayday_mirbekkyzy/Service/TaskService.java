package com.example.java_group_11_homework_56_ayday_mirbekkyzy.Service;

import com.example.java_group_11_homework_56_ayday_mirbekkyzy.DTO.TaskDTO;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.DTO.TaskInDTO;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity.Task;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Repository.TaskRepository;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Repository.TaskTypeRepository;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskTypeRepository typeRepository;
    private final UserRepository userRepository;

    public void createTask(String useremail, TaskInDTO taskDTO) {
        var type = typeRepository.findTaskTypeByName("NEW_WORK");
        var user = userRepository.findUserByEmail(useremail);
        if (user.isPresent()) {
            Task task = Task.builder()
                    .author(user.get())
                    .type(type)
                    .header(taskDTO.getHeader())
                    .description(taskDTO.getDescription())
                    .date(LocalDateTime.now())
                    .build();
            taskRepository.save(task);
        }
    }

    public void changeTaskType(Long taskId, String useremail) throws Exception {
        var task = taskRepository.findTaskByIdAndAuthorEmail(taskId, useremail);

        var newWork = typeRepository.findTaskTypeByName("NEW_WORK");
        var inWork = typeRepository.findTaskTypeByName("IN_WORK");
        var endWork = typeRepository.findTaskTypeByName("END_WORK");


        if (task.getType().equals(newWork)) {
            task.setType(inWork);
        } else if (task.getType().equals(inWork)) {
            task.setType(endWork);
        } else if (task.getType().equals(endWork)) {
            throw new Exception("You status of task is end!");
        }

        taskRepository.save(task);
    }


    public Slice<TaskDTO> showAllTasks(String useremail) {
        var tasks = taskRepository.findTasksByAuthorEmail(useremail);
        return tasks.map(TaskDTO::from);
    }

    public TaskInDTO showOneTask(Long taskId) {
        var task = taskRepository.findTaskById(taskId);
        return TaskInDTO.from(task.get());
    }

}
