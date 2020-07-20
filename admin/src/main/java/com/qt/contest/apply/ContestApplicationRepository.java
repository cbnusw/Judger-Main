package com.qt.contest.apply;

import com.qt.domain.contest.ContestApplication;
import com.qt.domain.contest.ContestProblemRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestApplicationRepository extends JpaRepository<ContestApplication, Long> {

    List<ContestApplication> findAllByContestId(Long contestId);

}
