package com.qt.contest.apply;

import com.qt.domain.contest.dto.ContestApplicationInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contests")
public class ContestApplicationController {

    private final ContestApplicationService contestApplicationService;

    public ContestApplicationController(ContestApplicationService contestApplicationService) {
        this.contestApplicationService = contestApplicationService;
    }

    //컨테스트 신청
    @PostMapping("/{contestId}/apply/{userId}")
    public ResponseEntity applyContest(@PathVariable Long contestId, @PathVariable Long userId) {
        Long contestApplicationId = contestApplicationService.apply(contestId, userId);
        return ResponseEntity.created(URI.create("/contests/apply/" + contestApplicationId)).build();
    }

    //해당 컨테스트의 특정유저의 신청내역(id,userId,contestId, createTime, isApprove)  조회
    @GetMapping("/apply/{contestApplicationId}")
    public ResponseEntity<ContestApplicationInfo> showContestApplication(@PathVariable Long contestApplicationId) {
        ContestApplicationInfo contestApplicationInfo = contestApplicationService.findByContestApplicationId(contestApplicationId);
        return ResponseEntity.ok(contestApplicationInfo);
    }

    //해당 컨테스트의 유저들의 신청내역(id,userId,contestId, createTime, isApprove) 모두 조회
    @GetMapping("/{contestId}/apply")
    public ResponseEntity<List<ContestApplicationInfo>> showContestApplications(@PathVariable Long contestId) {
        List<ContestApplicationInfo> contestApplicationInfos = contestApplicationService.findAllByContestId(contestId);
        return ResponseEntity.ok(contestApplicationInfos);
    }

    //해당 컨테스트의 신청을 승인 결정
    @PostMapping("/apply/approve/{contestApplicationId}")
    public ResponseEntity changeApproveStatus(@PathVariable Long contestApplicationId) {
        contestApplicationService.changeApproveStatus(contestApplicationId);
        return ResponseEntity.noContent().build();
    }
}
