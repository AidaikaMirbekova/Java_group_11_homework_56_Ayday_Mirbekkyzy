package com.example.java_group_11_homework_56_ayday_mirbekkyzy.DTO;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {

    Long id;
    String name;
    String email;
    String password;

}
