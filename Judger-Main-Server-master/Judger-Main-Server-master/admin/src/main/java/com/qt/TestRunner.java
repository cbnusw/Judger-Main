package com.qt;

import com.qt.problem.ProblemRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements ApplicationRunner {

    private final ProblemRepository problemRepository;

    public TestRunner(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Problem problem = new Problem("asd.pdf", "123", 1d, 1d);
//        problemRepository.save(problem);
    }
}
