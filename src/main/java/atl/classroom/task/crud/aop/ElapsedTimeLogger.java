package atl.classroom.task.crud.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ElapsedTimeLogger {

    @Pointcut(value = "execution(* atl.classroom.task.crud.service.serviceImpl.*.*(..))")
    public void elapsedTimePc() {
    }

    @SneakyThrows
    @Around(value = "elapsedTimePc()")
    public void elapsedTimeLogger(ProceedingJoinPoint jp) {
        long startDate = System.currentTimeMillis();
        jp.proceed();
        long endDate = System.currentTimeMillis();
        log.info("Elapsed time:{}", endDate - startDate);
    }

    @Before(value = "elapsedTimePc()")
    public void logAllParameters(JoinPoint jp) {
        Arrays.stream(jp.getArgs()).forEach(o -> log.info("All method args:{}", o));
        log.info("All method kinds :{}", jp.getKind());
    }
}
