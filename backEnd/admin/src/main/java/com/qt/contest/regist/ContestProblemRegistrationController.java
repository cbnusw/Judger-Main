package com.qt.contest.regist;

import com.qt.domain.problem.dto.ProblemResponseInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contests")
public class ContestProblemRegistrationController {

    private final ContestProblemRegistrationService contestProblemRegistrationService;

    public ContestProblemRegistrationController(ContestProblemRegistrationService contestProblemRegistrationService) {
        this.contestProblemRegistrationService = contestProblemRegistrationService;
    }

    @PostMapping("/{contestId}/problems")
    public ResponseEntity registerProblems(@PathVariable Long contestId, @RequestParam List<Long> problemIds) {
        contestProblemRegistrationService.register(contestId, problemIds);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{contestId}/problems")
    public ResponseEntity<List<ProblemResponseInfo>> showRegisteredProblems(@PathVariable Long contestId) {
        List<ProblemResponseInfo> problemResponseInfos = contestProblemRegistrationService.showRegisteredProblems(contestId);
        return ResponseEntity.ok(problemResponseInfos);
    }
}
