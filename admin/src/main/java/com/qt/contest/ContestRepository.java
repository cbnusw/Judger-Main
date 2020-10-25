package com.qt.contest;

import com.qt.domain.contest.Contest;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

@EntityScan("com.qt.contest.*")
@ComponentScan("com.qt.contest.*")
public interface ContestRepository extends JpaRepository<Contest, Long> {
}
