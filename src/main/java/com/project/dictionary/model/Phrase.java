package com.project.dictionary.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Phrase {
    @NonNull
    private String id;
    @NonNull
    private List<String> definition;
    @NonNull
    private List<String> translation;
    @NonNull
    private LocalDateTime creationDateTime;
    @NonNull
    private EducationStatus status = EducationStatus.NEW;
}
