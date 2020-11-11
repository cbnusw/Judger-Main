package com.qt.start;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class ContestStartController {
    private final ContestStartService contestStartService;

    public ContestStartController(ContestStartService contestStartService) {
        this.contestStartService = contestStartService;
    }

    //컨테스트승인+ 컨테스트 시간 체크
    @PostMapping("/start/contest/{cid}/user/{uid}")
    public ResponseEntity startContest(@PathVariable("cid")Long contestId, @PathVariable("uid")Long userId, @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) @RequestParam LocalDateTime time){
        System.out.println("승인: "+contestStartService.isUserApproveCheck(contestId,userId));
        //사용자가 컨테스트에 승인됬는지부터 확인한다.
        if(!contestStartService.isUserApproveCheck(contestId,userId)) return ResponseEntity.ok(false);
        //승인되었다면 ,컨테스트 시간(컨테스트 id에 해당하는 DB에서 시작,끝나는시간)을 체크한다
        //컨테스트가 가능한지알려주는 bool과, 남은 시간카운트(종료시간-접속시간)를 리턴한다.
        return ResponseEntity.ok(contestStartService.isContestTimeCheck(contestId,time));
    }
}
