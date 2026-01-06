package com.example.traningsystem.dto.schedule;

import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreateScheduleRequest {
    private Long id;
    private Long teacherId;
    private Long courseId;
    private Long GroupId;
    @FutureOrPresent
    private LocalDateTime scheduledTime;
}
