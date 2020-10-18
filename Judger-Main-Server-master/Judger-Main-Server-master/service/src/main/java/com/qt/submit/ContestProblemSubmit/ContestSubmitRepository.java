package com.qt.submit.ContestProblemSubmit;

import com.qt.domain.submit.ContestSubmit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestSubmitRepository extends JpaRepository<ContestSubmit,Long> {
    List<ContestSubmit> findAllByContestId(Long contestId);
}
