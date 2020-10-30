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

    //컨테스트 시작(컨테스트 id에 해당하는 DB에서 시작,끝나는시간을 체크한다)
    //컨테스트가 가능한지 bool과, 남은 시간카운트(종료시간-접속시간)를 리턴한다.
    @PostMapping("/start/contest/{id}")
    public ResponseEntity startContest(@PathVariable("id")Long contestId, @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) @RequestParam LocalDateTime time){
        return ResponseEntity.ok(contestStartService.isContestTimeCheck(contestId,time));
    }
}
