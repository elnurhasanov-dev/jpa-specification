package atl.classroom.task.crud.scheduler;

import atl.classroom.task.crud.service.TestSchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class TestScheduler {
    private final TestSchedulerService testSchedulerService;

    @Scheduled(fixedDelayString = "PT1M")
    public void call() {
        testSchedulerService.call();
    }
}
