package com.qt.problem.testcase;

import com.qt.domain.testcase.Testcase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestcaseRepository extends JpaRepository<Testcase,Long> {
}
