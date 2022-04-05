package com.example.java_group_11_homework_56_ayday_mirbekkyzy.Util;

import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity.TaskType;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity.User;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Repository.TaskRepository;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Repository.TaskTypeRepository;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
public class InitDataBase {

    @Bean
    public CommandLineRunner initData(TaskRepository taskRepository,
                                      TaskTypeRepository taskTypeRepository,
                                      UserRepository userRepository,
                                      PasswordEncoder encoder) {
        return (args) -> {
            taskRepository.deleteAll();
            taskTypeRepository.deleteAll();
            userRepository.deleteAll();

            TaskType type=new TaskType();
            type.setName("NEW_WORK");
            taskTypeRepository.save(type);

            TaskType type1=new TaskType();
            type1.setName("IN_WORK");
            taskTypeRepository.save(type1);

            TaskType type2=new TaskType();
            type2.setName("END_WORK");
            taskTypeRepository.save(type2);

            User user = new User();
            user.setName("Admin");
            user.setEmail("admin@test");
            user.setPassword(encoder.encode("admin"));
            userRepository.save(user);
        };
    }
}
