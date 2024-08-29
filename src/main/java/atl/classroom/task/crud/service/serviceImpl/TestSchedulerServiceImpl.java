package atl.classroom.task.crud.service.serviceImpl;

import atl.classroom.task.crud.service.TestSchedulerService;
import org.springframework.stereotype.Service;

@Service
public class TestSchedulerServiceImpl implements TestSchedulerService {
    @Override
    public void call() {
        System.out.println("Scheduler is working!");
    }
}
