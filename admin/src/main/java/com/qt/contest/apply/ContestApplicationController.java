package com.qt.contest.apply;

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

    @PostMapping("/{contestId}/apply/{userId}")
    public ResponseEntity applyContest(@PathVariable Long contestId, @PathVariable Long userId) {
        Long contestApplicationId = contestApplicationService.apply(contestId, userId);
        return ResponseEntity.created(URI.create("/contests/apply/" + contestApplicationId)).build();
    }

    @GetMapping("/apply/{contestApplicationId}")
    public ResponseEntity<ContestApplicationInfo> showContestApplication(@PathVariable Long contestApplicationId) {
        ContestApplicationInfo contestApplicationInfo = contestApplicationService.findByContestApplicationId(contestApplicationId);
        return ResponseEntity.ok(contestApplicationInfo);
    }

    @GetMapping("/{contestId}/apply")
    public ResponseEntity<List<ContestApplicationInfo>> showContestApplications(@PathVariable Long contestId) {
        List<ContestApplicationInfo> contestApplicationInfos = contestApplicationService.findAllByContestId(contestId);
        return ResponseEntity.ok(contestApplicationInfos);
    }

    @PostMapping("/apply/approve/{contestApplicationId}")
    public ResponseEntity changeApproveStatus(@PathVariable Long contestApplicationId) {
        contestApplicationService.changeApproveStatus(contestApplicationId);
        return ResponseEntity.noContent().build();
    }
}
