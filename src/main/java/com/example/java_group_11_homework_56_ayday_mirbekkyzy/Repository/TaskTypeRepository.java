package com.example.java_group_11_homework_56_ayday_mirbekkyzy.Repository;

import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity.TaskType;
import org.springframework.data.repository.CrudRepository;

public interface TaskTypeRepository extends CrudRepository<TaskType, Long> {

    TaskType findTaskTypeByName(String name);


}
