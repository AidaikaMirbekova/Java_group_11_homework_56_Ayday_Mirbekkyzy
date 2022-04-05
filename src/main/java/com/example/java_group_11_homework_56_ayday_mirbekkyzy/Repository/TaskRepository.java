package com.example.java_group_11_homework_56_ayday_mirbekkyzy.Repository;

import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity.Task;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    Slice<Task> findTasksByAuthorEmail(String useremail);

    Task findTaskByIdAndAuthorEmail(Long taskId, String useremail);

    Optional<Task> findTaskById(Long taskId);

}
