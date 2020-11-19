package com.qt.contest;

import com.qt.domain.contest.dto.ContestInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contests")
public class ContestController {

    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    //테스트 완료: 컨테스트를 등록하는부분으로, junit방식으로 테스트를하여 컨테스트정보들이 테이블내에 저장됨
    @PostMapping
    public ResponseEntity createContest(@ModelAttribute ContestInfo contestInfo) {
        Long id = contestService.save(contestInfo);
        return ResponseEntity.created(URI.create("/contests/" + id)).build();
    }

    //테스트 완료: 등록된 모든 컨테스트들을 조회 하는부분
    @GetMapping
    public ResponseEntity<List<ContestInfo>> showAllContestInfo() {
        List<ContestInfo> contestInfos = contestService.findAll();
        return ResponseEntity.ok(contestInfos);
    }

    //테스트 완료: 등록된 컨테스트들중 특정 id를 가진 컨테스트를 조회 하는부분
    @GetMapping("/{id}")
    public ResponseEntity<ContestInfo> showContestInfo(@PathVariable Long id) {
        ContestInfo contestInfo = contestService.findById(id);
        return ResponseEntity.ok(contestInfo);
    }

    //테스트 완료: 등록된 컨테스트를 수정 하는부분
    @PostMapping("/{id}")
    public ResponseEntity updateContest(@PathVariable Long id, @ModelAttribute ContestInfo contestInfo) {
        contestService.updateContest(id, contestInfo);
        return ResponseEntity.noContent().build();
    }

    //테스트 완료: 등록된 컨테스트를 삭제하는부분
    @DeleteMapping("/{id}")
    public ResponseEntity deleteContest(@PathVariable Long id) {
        contestService.deleteContest(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity eventErrorHandler(RuntimeException exception) {
        return ResponseEntity.notFound().build();
    }
}
