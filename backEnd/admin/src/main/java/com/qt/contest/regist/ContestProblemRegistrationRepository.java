package com.qt.contest.regist;

import com.qt.domain.contest.ContestProblemRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestProblemRegistrationRepository extends JpaRepository<ContestProblemRegistration, Long> {

    List<ContestProblemRegistration> findAllByContestId(Long contestId);
}
