package atl.classroom.task.crud.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
}
