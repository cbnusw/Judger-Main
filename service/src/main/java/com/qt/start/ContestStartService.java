package com.qt.start;

import com.qt.contest.ContestRepository;
import com.qt.contest.NotFoundContestException;
import com.qt.domain.contest.Contest;
import com.qt.domain.start.ContestStartInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@Transactional
public class ContestStartService {

    private final ContestRepository contestRepository;

    public ContestStartService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }
    public ContestStartInfo isContestTimeCheck(Long id, LocalDateTime curTime){
        Contest contest=contestRepository.findById(id).orElseThrow(NotFoundContestException::new);
        LocalDateTime startTime=contest.getStartTime();
        LocalDateTime endTime=contest.getEndTime();
        long Remainingtime=0;
        boolean isContestPossilbe=(curTime.isAfter(startTime))&&(curTime.isBefore(endTime));
        ContestStartInfo contestStartInfo=new ContestStartInfo();
        contestStartInfo.setPossilbe(isContestPossilbe);
        System.out.println(isContestPossilbe);
        //시작시간, 끝나는시간 사이에있다면 true
        if(isContestPossilbe) {
            //(끝나는시간-들어온시간)
            Remainingtime = Duration.between(curTime, endTime).getSeconds();
            contestStartInfo.setRemainingTime(Remainingtime);
            System.out.println(contestStartInfo.getRemainingTime());
            return contestStartInfo;
        }
        contestStartInfo.setRemainingTime(0);
        System.out.println(contestStartInfo.getRemainingTime());
        return contestStartInfo;





    }
}
