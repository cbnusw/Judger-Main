package com.qt.question;


import com.qt.domain.question.dto.QuestionInfo; //아래꺼로 경로지정하고 삭제할것
import core.src.main.java.com.qt.domain.question.dto.QuestionInfo; //경로지정할것(설정 조정??)
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class QuestionController {

    private final QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/contests/{id}/questions")
    public ResponseEntity createQuestion(@PathVariable("id")Long contestId, @ModelAttribute QuestionInfo questionInfo) {
        Long id = questionService.save(contestId, questionInfo);
        return ResponseEntity.created(URI.create("/questions/" + id)).build();
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<QuestionInfo> showContestInfo(@PathVariable Long id) {
        QuestionInfo questionInfo = questionService.findById(id);
        return ResponseEntity.ok(questionInfo);
    }

// TODO : 역시 컨트롤러 Update 부분도 의논 사항
//    @PostMapping("/{id}")
//    public ResponseEntity updateContest(@PathVariable Long id, @ModelAttribute QuestionInfo questionInfo) {
//        questionService.updateQuestion(id, questionInfo);
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/questions/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity<?> eventErrorHandler(NotFoundQuestionException exception) {
        return ResponseEntity.notFound().build();
    }
}
