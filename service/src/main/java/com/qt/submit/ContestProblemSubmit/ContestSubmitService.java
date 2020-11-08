package com.qt.submit.ContestProblemSubmit;

import com.qt.repository.ContestRepository;
import com.qt.contest.NotFoundContestException;
import com.qt.repository.ContestProblemRegistrationRepository;
import com.qt.domain.contest.Contest;
import com.qt.domain.problem.Problem;
import com.qt.domain.submit.ContestSubmit;
import com.qt.domain.submit.dto.ContestSubmitResponse;
import com.qt.domain.submit.dto.ScoreBoard;
import com.qt.domain.submit.dto.SubmitRequest;
import com.qt.domain.user.User;
import com.qt.problem.NotFoundProblemException;
import com.qt.repository.ProblemRepository;
import com.qt.submit.NotFoundSubmitException;
import com.qt.submit.SubmitRepository;
import com.qt.submit.SubmitService;
import com.qt.user.NotFoundUserException;
import com.qt.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContestSubmitService extends SubmitService {
    private final ProblemRepository problemRepository;
    private final UserRepository userRepository;
    private final ContestRepository contestRepository;
    private final ContestSubmitRepository contestSubmitRepository;
    private final ModelMapper modelMapper;

    public ContestSubmitService(ProblemRepository problemRepository, UserRepository userRepository, SubmitRepository submitRepository, ModelMapper modelMapper, ContestProblemRegistrationRepository contestProblemRegistrationRepository, ProblemRepository problemRepository1, UserRepository userRepository1, ContestRepository contestRepository, ContestSubmitRepository contestSubmitRepository, ModelMapper modelMapper1) {
        super(problemRepository, userRepository, submitRepository, modelMapper);
        this.problemRepository = problemRepository1;
        this.contestRepository = contestRepository;
        this.userRepository = userRepository1;
        this.contestSubmitRepository = contestSubmitRepository;
        this.modelMapper = modelMapper1;
    }



    public void Save(Long contestId, Long problemId ,Long userId, SubmitRequest submitRequest) {
        String response=ReadTestCase(problemId,submitRequest);

        //테이블에 저장
        ContestSubmitResponse contestSubmitResponse =new ContestSubmitResponse();
        Contest contest=contestRepository.findById(contestId).orElseThrow(NotFoundContestException::new);
        Problem problem=problemRepository.findById(problemId).orElseThrow(NotFoundProblemException::new);
        User user=userRepository.findById(userId).orElseThrow(NotFoundUserException::new);
        contestSubmitResponse.setSubmitCount(1);
        contestSubmitResponse.setLanguage(submitRequest.getLanguage());
        contestSubmitResponse.setContest(contest);
        contestSubmitResponse.setProblem(problem);
        contestSubmitResponse.setUser(user);
        contestSubmitResponse.setResult(response);
        ContestSubmit submit= contestSubmitResponse.toEntity();
        contestSubmitRepository.save(submit);
    }

    public List<ScoreBoard> findScoreBoard(Long contestId){
        List<ScoreBoard> scoreBoards=contestSubmitRepository.findAllByContestId(contestId).stream()
                .map(contestSubmit -> ScoreBoard.builder()
                        .problemName(contestSubmit.getProblem().getName())
                        .studentCode(contestSubmit.getUser().getUniversityCode())
                        .result(contestSubmit.getResult())
                        .score(0).build())
                .collect(Collectors.toList());;
        return scoreBoards;

    }



    @Transactional //영속성컨텍스트에서 변경을감지하려면 @Transactional어노테이션을 써야한다. + //@Transactiona을쓰지않으면 영속성전이가되지않는다 1차캐시저장x
    public Long retrySubmit(Long id, SubmitRequest submitRequest){
        ContestSubmit contestSubmit=contestSubmitRepository.findById(id).orElseThrow(NotFoundSubmitException::new);
        return contestSubmit.UpdateTo(submitRequest);
    }



}
