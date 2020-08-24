package com.qt.submit;

import com.qt.domain.submit.dto.SubmitResponse;
import com.qt.domain.submit.dto.SubmitRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class SubmitController {

    private final SubmitService submitService;


    public SubmitController(SubmitService submitService) {
        this.submitService = submitService;
    }

    //코드 제출
    @PostMapping("/submit/problems/{pid}/users/{uid}")
    public ResponseEntity submitProblem(@PathVariable("pid") Long problemId, @PathVariable("uid") Long userId, SubmitRequest submitRequest) {
        submitService.Save(problemId, userId, submitRequest);

        return ResponseEntity.noContent().build();

    }


    //결과 확인
    @GetMapping("submit/{id}")
    public ResponseEntity submitResult(@PathVariable("id") Long submitId) {
        SubmitResponse submitResponse =submitService.findByid(submitId);
        return ResponseEntity.ok(submitResponse);


    }

}
