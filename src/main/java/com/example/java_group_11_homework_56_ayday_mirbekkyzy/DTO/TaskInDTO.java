package com.example.java_group_11_homework_56_ayday_mirbekkyzy.DTO;

import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity.Task;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class TaskInDTO {

    public static TaskInDTO from(Task task){
        return builder()
                .header(task.getHeader())
                .description(task.getDescription())
                .date(task.getDate())
                .build();
    }

    @JsonProperty("header")
    private String header;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date")
    private LocalDateTime date;

}
