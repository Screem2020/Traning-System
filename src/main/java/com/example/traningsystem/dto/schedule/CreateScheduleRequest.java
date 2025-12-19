package com.example.traningsystem.dto.schedule;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreateScheduleRequest {
    private Long scheduleId;
    private Long teacherId;
    private Long courseId;
    private Long GroupId;
    private LocalDateTime scheduledTime;
}
