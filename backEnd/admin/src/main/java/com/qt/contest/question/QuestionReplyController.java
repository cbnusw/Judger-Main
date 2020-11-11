package com.qt.contest.question;

import com.qt.domain.question.dto.QuestionInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//질문답변, 답변삭제
@RestController
public class QuestionReplyController {
    private final QuestionReplyService questionReplyService;

    public QuestionReplyController(QuestionReplyService questionManageService) {
        this.questionReplyService = questionManageService;
    }

    //질문 답변(수정) (Question테이블 수정)
    @PostMapping("/question/{id}/reply")
    public ResponseEntity<QuestionInfo> replyQuestionInfo(@PathVariable("id")Long questionId, String reply){
        System.out.println("test: "+reply);
        questionReplyService.replyQuestion(questionId,reply);
        return ResponseEntity.noContent().build();
    }


    //답변 삭제-> reply를 공백으로
    @DeleteMapping("/question/{id}/reply/delete")
    public ResponseEntity<QuestionInfo> deleteQuestionInfo(@PathVariable("id")Long questionId){
        questionReplyService.deleteQuestion(questionId);
        return ResponseEntity.noContent().build();
    }



}


