package com.example.traningsystem.dto.schedule;

import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ScheduleDto {
    private Long scheduleId;
    private Long groupId;
    private Long teacherId;
    private Long courseId;
    @FutureOrPresent
    private LocalDateTime scheduledTime;
}
