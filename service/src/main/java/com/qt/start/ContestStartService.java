package com.qt.start;

import com.qt.repository.ContestRepository;
import com.qt.contest.NotFoundContestException;
import com.qt.repository.ContestApplicationRepository;
import com.qt.domain.contest.Contest;
import com.qt.domain.contest.ContestApplication;
import com.qt.domain.start.ContestStartInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@Transactional
public class ContestStartService {

    private final ContestRepository contestRepository;
    private final ContestApplicationRepository contestApplicationRepository;

    public ContestStartService(ContestRepository contestRepository, ContestApplicationRepository contestApplicationRepository) {
        this.contestRepository = contestRepository;
        this.contestApplicationRepository = contestApplicationRepository;
    }
    public ContestStartInfo isContestTimeCheck(Long contestId, LocalDateTime curTime){
        Contest contest=contestRepository.findById(contestId).orElseThrow(NotFoundContestException::new);
        LocalDateTime startTime=contest.getStartTime(); LocalDateTime endTime=contest.getEndTime();
        long Remainingtime=0;
        boolean isContestPossilbe=(curTime.isAfter(startTime))&&(curTime.isBefore(endTime));

        ContestStartInfo contestStartInfo=new ContestStartInfo();
        contestStartInfo.setPossilbe(isContestPossilbe);
        System.out.println("컨테스트 시간: "+isContestPossilbe);
        //시작시간, 끝나는시간 사이에있다면 true
        if(isContestPossilbe) {
            //(끝나는시간-들어온시간)
            Remainingtime = Duration.between(curTime, endTime).getSeconds();
            contestStartInfo.setRemainingTime(Remainingtime);
            System.out.println("남은시간: "+contestStartInfo.getRemainingTime());
            return contestStartInfo;
        }
        contestStartInfo.setRemainingTime(0);
        System.out.println("남은시간: "+contestStartInfo.getRemainingTime());
        return contestStartInfo;
    }

    //해당유저가 해당 컨테스트를 신청했고, 승인이됬다면 true 리턴
    public boolean isUserApproveCheck(long contestId,long userId){
        ContestApplication contestApplication=contestApplicationRepository.findByContestIdAndUserId(contestId,userId);
        if(contestApplication!=null && contestApplication.getIsApproved())
                    return true;

        return false;
    }
}
