package com.project.task;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
public class Task {

    private String name;

    private Status status;

    private LocalDateTime creationDate;

    private LocalDateTime finishDate;

    private String description;

    private Set<Tag> tags;
}
