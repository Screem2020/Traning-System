package com.example.traningsystem.config;

import com.example.traningsystem.dao.ScheduleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Slf4j
@Component
@DisallowConcurrentExecution
@AllArgsConstructor
public class ScheduleDeleteJob {

    private ScheduleRepository repository;

    @Scheduled(cron = "0 0 0 1 1 *", zone = "Europe/Moscow")
    public void deleteScheduleByTimeEnd() {
        LocalDateTime timeEnd = LocalDateTime.now().minusYears(1);
        repository.deleteAllOlderThan(timeEnd);
        log.info("Schedule delete by time end");
    }

}
