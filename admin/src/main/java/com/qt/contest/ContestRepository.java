package com.qt.contest;

import com.qt.domain.contest.Contest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

@ComponentScan("com.qt.contest.ContestRepository")
public interface ContestRepository extends JpaRepository<Contest, Long> {
}
