package com.qt.contest;

import com.qt.domain.contest.Contest;
import com.qt.domain.contest.dto.ContestInfo;
import com.qt.repository.ContestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContestService {

    private final ContestRepository contestRepository;
    private final ModelMapper modelMapper;

    public ContestService(ContestRepository contestRepository, ModelMapper modelMapper) {
        this.contestRepository = contestRepository;
        this.modelMapper = modelMapper;
    }

    public Long save(ContestInfo contestInfo) {
        Contest contest = contestInfo.toEntity();
        return contestRepository.save(contest).getId();
    }

    @Transactional(readOnly = true)
    public List<ContestInfo> findAll() {
        return contestRepository.findAll().stream()
                .map(contest -> modelMapper.map(contest, ContestInfo.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContestInfo findById(Long id) {
        Contest contest = contestRepository.findById(id).orElseThrow(RuntimeException::new);
        return modelMapper.map(contest, ContestInfo.class);
    }

    public Long updateContest(Long id, ContestInfo contestInfo) {
        Contest contest = contestRepository.findById(id).orElseThrow(RuntimeException::new);
        return contest.updateTo(contestInfo);
    }

    public void deleteContest(Long id) {
        contestRepository.deleteById(id);
    }
}
