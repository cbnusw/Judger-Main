package com.qt.question;

import com.qt.contest.ContestRepository;
import com.qt.contest.NotFoundContestException;
import com.qt.domain.contest.Contest;
import com.qt.domain.question.Question;
import com.qt.domain.question.dto.QuestionInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class QuestionService {

    private final ContestRepository contestRepository;
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    //contestRepository 그리고 questionRepository 쪽에서 error
    public QuestionService(ContestRepository contestRepository, QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.contestRepository = contestRepository;
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }

    public Long save(Long contestId, QuestionInfo questionInfo) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(NotFoundContestException::new);

        questionInfo.setContest(contest);

        Question question = questionInfo.toEntity();
        return questionRepository.save(question).getId();
    }

    @Transactional(readOnly = true)
    public QuestionInfo findById(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(NotFoundQuestionException::new);
        return modelMapper.map(question, QuestionInfo.class);
    }

// TODO: 질문이 과연 Update가 필요한건지? 일회성으로 끝나야 하는건지 의논해야함.
//    public Long updateQuestion(Long id, QuestionInfo questionInfo) {
//        Question question = questionRepository.findById(id).orElseThrow(NotFoundQuestionException::new);
//        return question.updateTo(questionInfo);
//    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
