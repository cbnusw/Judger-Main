package com.qt.repository;

import com.qt.domain.contest.ContestApplication;
import com.qt.domain.contest.ContestProblemRegistration;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestApplicationRepository extends JpaRepository<ContestApplication, Long> {

   // @EntityGraph(attributePaths = {"user","contest"},type = EntityGraph.EntityGraphType.FETCH)
    List<ContestApplication> findAllByContestId(Long contestId);
    ContestApplication findByContestIdAndUserId(Long contestId,Long userId);

}
