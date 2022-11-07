package com.rejointech.Rejoinschool.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
