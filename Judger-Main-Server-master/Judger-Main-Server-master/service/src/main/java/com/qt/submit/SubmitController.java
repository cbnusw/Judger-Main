package com.qt.submit;

import com.qt.domain.submit.SubmitInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class SubmitController {

    private final SubmitService submitService;

    public SubmitController(SubmitService submitService) {
        this.submitService = submitService;
    }

    //코드 제출
    @PostMapping("problems/{id}/submit")
    public ResponseEntity submitProblem(@PathVariable("id")Long problemId, SubmitInfo submitInfo){
        submitService.ReadTestcase(problemId,submitInfo);

        return ResponseEntity.noContent().build();

        }
}
