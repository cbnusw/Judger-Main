
package com.qt.contest.question;

import com.qt.repository.QuestionRepository;
import com.qt.domain.question.Question;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionReplyService {
    private final QuestionRepository questionRepository;

    public QuestionReplyService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public void replyQuestion(Long id, String reply_content){
        Question question=questionRepository.findById(id).orElseThrow(RuntimeException::new);
        question.updateTo(reply_content);
    }

    public void deleteQuestion(Long id){
        Question question=questionRepository.findById(id).orElseThrow(RuntimeException::new);
        question.updateTo(null);
    }






}


