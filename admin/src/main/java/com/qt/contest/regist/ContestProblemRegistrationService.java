package com.qt.contest.regist;

import com.qt.repository.ContestProblemRegistrationRepository;
import com.qt.repository.ContestRepository;
import com.qt.domain.contest.Contest;
import com.qt.domain.contest.ContestProblemRegistration;
import com.qt.domain.problem.dto.ProblemResponseInfo;
import com.qt.repository.ProblemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContestProblemRegistrationService {

    private final ContestRepository contestRepository;
    private final ProblemRepository problemRepository;
    private final ContestProblemRegistrationRepository contestProblemRegistrationRepository;
    private final ModelMapper modelMapper;

    public ContestProblemRegistrationService(ContestRepository contestRepository, ProblemRepository problemRepository, ContestProblemRegistrationRepository contestProblemRegistrationRepository, ModelMapper modelMapper) {
        this.contestRepository = contestRepository;
        this.problemRepository = problemRepository;
        this.contestProblemRegistrationRepository = contestProblemRegistrationRepository;
        this.modelMapper = modelMapper;
    }

    public void register(Long contestId, List<Long> problemIds) {
        Contest contest = contestRepository.findById(contestId).orElseThrow(RuntimeException::new);

        problemIds.stream()
                .map(id -> problemRepository.findById(id).orElseThrow(RuntimeException::new)) //id를 하나씩가져와 prolbem을만든다.
                .forEach(problem -> contestProblemRegistrationRepository.save(new ContestProblemRegistration(contest, problem))); //ContestProblemRegistration 엔티티에 Contest와 각 Problem을저장한다.
    }

    @Transactional(readOnly = true)
    public List<ProblemResponseInfo> showRegisteredProblems(Long contestId) {
        List<ContestProblemRegistration> contestProblemRegistrations = contestProblemRegistrationRepository.findAllByContestId(contestId);

        return contestProblemRegistrations.stream()
                .map(registration -> modelMapper.map(registration.getProblem(), ProblemResponseInfo.class))
                .collect(Collectors.toList());

    }
}
