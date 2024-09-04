package atl.classroom.task.crud.scheduler;

import atl.classroom.task.crud.service.DemoSchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class DemoScheduler {
    private final DemoSchedulerService testSchedulerService;

    @Scheduled(fixedDelayString = "PT1M")
    public void call() {
        testSchedulerService.call();
    }
}
