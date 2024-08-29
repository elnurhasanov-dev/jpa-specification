package atl.classroom.task.crud.controller;

import atl.classroom.task.crud.service.serviceImpl.TestTransactionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/transaction")
@RequiredArgsConstructor
public class TestTransactionalController {
    private final TestTransactionalService transactionalService;

    @GetMapping("/test")
    public void test() {
        transactionalService.test();
    }

    @GetMapping("/test2")
    public void test2() throws Exception {
        transactionalService.test2();
    }

    @GetMapping("/test3")
    public void test3() {
        transactionalService.test3();
    }

    @GetMapping("/test4")
    public void test4() throws Exception {
        transactionalService.test4();
    }

    @GetMapping("/test5")
    public void test5()  {
        transactionalService.test5();
    }

    @GetMapping("/test6")
    public void test6()  {
        transactionalService.test6();
    }
}
