package com.qt.question;


import com.qt.domain.question.dto.QuestionInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class QuestionController {

    private final QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //질문 등록
    @PostMapping("/contests/{id}/questions")
    public ResponseEntity createQuestion(@PathVariable("id")Long contestId, @ModelAttribute QuestionInfo questionInfo) {
        Long id = questionService.save(contestId, questionInfo);
        return ResponseEntity.created(URI.create("/questions/" + id)).build();
    }

    //질문 조회
    @GetMapping("/questions/{id}")
    public ResponseEntity<QuestionInfo> showQuestionInfo(@PathVariable Long id) {
        QuestionInfo questionInfo = questionService.findById(id);
        return ResponseEntity.ok(questionInfo);
    }

    //질문 모두 조회
    @GetMapping("/questions")
    public ResponseEntity<List<QuestionInfo>> showQuestion(){
        List<QuestionInfo> questionInfos=questionService.findAll();
        return ResponseEntity.ok(questionInfos);

    }

// TODO : 역시 컨트롤러 Update 부분도 의논 사항
//    @PostMapping("/{id}")
//    public ResponseEntity updateContest(@PathVariable Long id, @ModelAttribute QuestionInfo questionInfo) {
//        questionService.updateQuestion(id, questionInfo);
//        return ResponseEntity.noContent().build();
//    }

    //질문 삭제
    @DeleteMapping("/questions/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity<?> eventErrorHandler(RuntimeException exception) {
        return ResponseEntity.notFound().build();
    }
}
