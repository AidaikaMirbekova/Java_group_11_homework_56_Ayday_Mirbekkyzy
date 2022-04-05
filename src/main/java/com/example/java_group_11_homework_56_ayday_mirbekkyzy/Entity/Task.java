package com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "header_id")
    private String header;

    @JoinColumn(name = "description_id")
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "type")
    private TaskType type;

    @Column(name = "date_task")
    private LocalDateTime date;
}
