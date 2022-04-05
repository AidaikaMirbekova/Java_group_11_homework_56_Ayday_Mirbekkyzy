package com.example.java_group_11_homework_56_ayday_mirbekkyzy.DTO;

import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity.Task;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class TaskDTO {

    public static TaskDTO from(Task task) {
        return builder()
                .id(task.getId())
                .header(task.getHeader())
                .status(task.getType().getId())
                .date(task.getDate())
                .build();
    }

    @JsonProperty("id")
    private Long id;

    @JsonProperty("header")
    private String header;

    @JsonProperty("typeId")
    private Long status;

    @JsonProperty("date")
    private LocalDateTime date;


}
