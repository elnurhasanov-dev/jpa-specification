package atl.classroom.task.crud.service.serviceImpl;

import atl.classroom.task.crud.service.DemoSchedulerService;
import org.springframework.stereotype.Service;

@Service
public class DemoSchedulerServiceImpl implements DemoSchedulerService {
    @Override
    public void call() {
        System.out.println("Scheduler is working!");
    }
}
