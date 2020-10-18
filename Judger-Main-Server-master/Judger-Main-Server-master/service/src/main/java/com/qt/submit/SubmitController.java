package com.qt.submit;

import com.qt.domain.submit.ContestSubmit;
import com.qt.domain.submit.dto.ScoreBoard;
import com.qt.domain.submit.dto.SubmitResponse;
import com.qt.domain.submit.dto.SubmitRequest;
import com.qt.submit.ContestProblemSubmit.ContestSubmitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SubmitController {

    private final SubmitService submitService;
    private final ContestSubmitService contestSubmitService;


    public SubmitController(SubmitService submitService, ContestSubmitService contestSubmitService) {
        this.submitService = submitService;
        this.contestSubmitService = contestSubmitService;
    }

    //코드 제출(문제)
    @PostMapping("/submit/problems/{pid}/users/{uid}")
    public ResponseEntity submitProblem(@PathVariable("pid") Long problemId, @PathVariable("uid") Long userId, SubmitRequest submitRequest) {
        submitService.Save(problemId, userId, submitRequest);

        return ResponseEntity.noContent().build();

    }

    //코드 제출(컨테스트 문제)
    @PostMapping("/submit/contests/{cid}/problems/{pid}/users/{uid}")
    public ResponseEntity submitContest(@PathVariable("cid")Long contestId, @PathVariable("pid")Long problemId,@PathVariable("uid") Long userId, SubmitRequest submitRequest){
        contestSubmitService.Save(contestId,problemId,userId,submitRequest);

        return ResponseEntity.noContent().build();

    }

    //코드 재제출(컨테스트 문제)
    @PostMapping("/submit/retry/{id}")
    public ResponseEntity resubmitContest(@PathVariable("id")Long submitId, SubmitRequest submitRequest){
        contestSubmitService.retrySubmit(submitId,submitRequest);
        return ResponseEntity.noContent().build();
    }

    //코드 제출(과제)



    //결과 확인
    @GetMapping("submit/{id}")
    public ResponseEntity submitResult(@PathVariable("id") Long submitId) {
        SubmitResponse submitResponse =submitService.findByid(submitId);
        return ResponseEntity.ok(submitResponse);


    }

    //해당컨테스트 전체결과 확인 스코어보드
    @GetMapping("contestSubmit/{id}")
    public ResponseEntity submitAllResult(@PathVariable("id")Long contestId){
        List<ScoreBoard> contestSubmit=contestSubmitService.findScoreBoard(contestId);
        return ResponseEntity.ok(contestSubmit);

    }

}
