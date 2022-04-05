package com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "task_type")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
