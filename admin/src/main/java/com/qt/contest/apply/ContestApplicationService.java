package com.qt.contest.apply;

import com.qt.domain.contest.dto.ContestApplicationInfo;
import com.qt.repository.ContestApplicationRepository;
import com.qt.repository.ContestRepository;
import com.qt.domain.contest.Contest;
import com.qt.domain.contest.ContestApplication;
import com.qt.domain.contest.dto.ContestInfo;
import com.qt.domain.user.User;
import com.qt.domain.user.dto.UserInfo;
import com.qt.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContestApplicationService {

    private final ContestRepository contestRepository;
    private final UserRepository userRepository;
    private final ContestApplicationRepository contestApplicationRepository;
    private final ModelMapper modelMapper;

    public ContestApplicationService(ContestRepository contestRepository, UserRepository userRepository, ContestApplicationRepository contestApplicationRepository, ModelMapper modelMapper) {
        this.contestRepository = contestRepository;
        this.userRepository = userRepository;
        this.contestApplicationRepository = contestApplicationRepository;
        this.modelMapper = modelMapper;
    }

    public Long apply(Long contestId, Long userId) {
        Contest contest = contestRepository.findById(contestId).orElseThrow(RuntimeException::new);
        User user = userRepository.findById(userId).orElseThrow(RuntimeException::new);
        return contestApplicationRepository.save(new ContestApplication(contest, user)).getId();
    }

    //단일조회 //질문 userinfo와 contestinfo의 id는 왜 조회되는지
    @Transactional(readOnly = true)
    public ContestApplicationInfo findByContestApplicationId(Long contestApplicationId) {
        ContestApplication contestApplication = contestApplicationRepository.findById(contestApplicationId).orElseThrow(RuntimeException::new);
        return ContestApplicationInfo.builder()
                .id(contestApplication.getId())
                .contestInfo(modelMapper.map(contestApplication.getContest(), ContestInfo.class))
                .userInfo(modelMapper.map(contestApplication.getUser(), UserInfo.class))
                .isApproved(contestApplication.getIsApproved()).build();
    }

    //모두조회
    @Transactional(readOnly = true)
    public List<ContestApplicationInfo> findAllByContestId(Long contestId) {
        return contestApplicationRepository.findAllByContestId(contestId).stream()
                .map(contestApplication -> ContestApplicationInfo.builder()
                        .id(contestApplication.getId())
                        .contestInfo(modelMapper.map(contestApplication.getContest(), ContestInfo.class))
                        .userInfo(modelMapper.map(contestApplication.getUser(), UserInfo.class))
                        .isApproved(contestApplication.getIsApproved()).build())
                .collect(Collectors.toList());
    }

    public void changeApproveStatus(Long contestApplicationId) {
        ContestApplication contestApplication = contestApplicationRepository.findById(contestApplicationId).orElseThrow(RuntimeException::new);
        contestApplication.changeApproveStatus();
    }
}
