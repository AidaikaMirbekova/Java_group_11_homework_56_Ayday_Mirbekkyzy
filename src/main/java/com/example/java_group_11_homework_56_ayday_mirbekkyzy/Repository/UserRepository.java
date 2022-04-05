package com.example.java_group_11_homework_56_ayday_mirbekkyzy.Repository;

import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> getByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
