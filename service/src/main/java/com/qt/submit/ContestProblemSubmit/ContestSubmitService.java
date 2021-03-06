package com.qt.submit.ContestProblemSubmit;

import com.qt.repository.*;
import com.qt.domain.contest.Contest;
import com.qt.domain.problem.Problem;
import com.qt.domain.submit.ContestSubmit;
import com.qt.domain.submit.dto.ContestSubmitResponse;
import com.qt.domain.submit.dto.ScoreBoard;
import com.qt.domain.submit.dto.SubmitRequest;
import com.qt.domain.user.User;
import com.qt.repository.SubmitRepository;
import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContestSubmitService{
    private final ProblemRepository problemRepository;
    private final UserRepository userRepository;
    private final ContestRepository contestRepository;
    private final ContestSubmitRepository contestSubmitRepository;
    private final ModelMapper modelMapper;

    //메인서버의 코드, 테스트케이스를 json형식으로 채점서버로 post방식으로 전송
    protected static final String LOCAL_PROBLEM_STORAGE_PATH = "C:\\Users\\jtm06\\javaProject\\git_home\\Judger-Main-Server-master\\admin\\src\\main\\resources\\problems";
    protected static final String TEST_CASE_PATH = "/tc";
    protected static final String TEST_CASE_INPUT_PATH = "/in";
    protected static final String TEST_CASE_OUTPUT_PATH = "/out";
    protected static final String SCORING_SERVER_URL = "http://172.30.1.6:3012/api/judge";
    //테스트케이스파일 개수
    int testCase_Num = 1;


    public ContestSubmitService(ProblemRepository problemRepository, UserRepository userRepository, SubmitRepository submitRepository, ModelMapper modelMapper, ContestProblemRegistrationRepository contestProblemRegistrationRepository, ProblemRepository problemRepository1, UserRepository userRepository1, ContestRepository contestRepository, ContestSubmitRepository contestSubmitRepository, ModelMapper modelMapper1) {

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
        Contest contest=contestRepository.findById(contestId).orElseThrow(RuntimeException::new);
        Problem problem=problemRepository.findById(problemId).orElseThrow(RuntimeException::new);
        User user=userRepository.findById(userId).orElseThrow(RuntimeException::new);
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
                        .studentCode(contestSubmit.getUser().getUserId())
                        .result(contestSubmit.getResult())
                        .score(0).build())
                .collect(Collectors.toList());;
        return scoreBoards;

    }



    @Transactional //영속성컨텍스트에서 변경을감지하려면 @Transactional어노테이션을 써야한다. + //@Transactiona을쓰지않으면 영속성전이가되지않는다 1차캐시저장x
    public Long retrySubmit(Long id, SubmitRequest submitRequest){
        ContestSubmit contestSubmit=contestSubmitRepository.findById(id).orElseThrow(RuntimeException::new);
        return contestSubmit.UpdateTo(submitRequest);
    }

    public String ReadTestCase(Long problemId, SubmitRequest submitRequest){
        System.out.println("ReadTestCase 시작: ");
        //테스트케이스 input, out파일일
        File input_tc_file = new File(LOCAL_PROBLEM_STORAGE_PATH + problemId + TEST_CASE_PATH + TEST_CASE_INPUT_PATH + "/" + testCase_Num + ".txt");
        File output_tc_file = new File(LOCAL_PROBLEM_STORAGE_PATH + problemId + TEST_CASE_PATH + TEST_CASE_OUTPUT_PATH + "/" + testCase_Num + ".txt");

        //채점서버로부터 응답
        String response="";
        //테스트케이스 시작
        //테스트케이스.txt파일이 있다면 반복문진행
        while (input_tc_file.exists() && output_tc_file.exists()) {
            try {
                System.out.println("테스트 케이스 시작: " + testCase_Num + ".txt");
                BufferedReader input_tc = new BufferedReader(new FileReader(LOCAL_PROBLEM_STORAGE_PATH + problemId + TEST_CASE_PATH + TEST_CASE_INPUT_PATH + "/" + testCase_Num + ".txt"));
                BufferedReader output_tc = new BufferedReader(new FileReader(LOCAL_PROBLEM_STORAGE_PATH + problemId + TEST_CASE_PATH + TEST_CASE_OUTPUT_PATH + "/" + testCase_Num + ".txt"));

                JSONObject source_info = new JSONObject();

                //code
                String code = submitRequest.getSource();
                source_info.put("source", code);
                System.out.println("source: " + code);

                //language
                String language = submitRequest.getLanguage();
                source_info.put("language", language);
                System.out.println("language: " + language);


                //input
                String input_temp;
                String input = "";
                while ((input_temp = input_tc.readLine()) != null) input += input_temp + "\n";
                System.out.println("input: " + input);
                source_info.put("input", input);

                //output
                String temp;
                String output = "";
                while ((temp = output_tc.readLine()) != null) output += temp;
                System.out.println("output: " + output);
                source_info.put("answer", output);
                String jsonmessg = source_info.toJSONString();
                System.out.println("jsonTest: " + jsonmessg);

                //채점서버연결->전송
                response=Send_ScoringServer(jsonmessg);
                System.out.println("채점서버에서온 응답: "+response);

                //테스트케이스가 컴파일에러인경우 반복문 탈출 종료
                if(response.contains("Compile Error")){
                    return "컴파일 에러 입니다!";
                }

                //테스트케이스가 틀린경우 반복문 탈출 종료
                else if(response.contains("WRONG")){
                    return "정답이 아닙니다!";
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }

            //다음 테스트케이스 준비
            testCase_Num++;
            input_tc_file = new File(LOCAL_PROBLEM_STORAGE_PATH + problemId + TEST_CASE_PATH + TEST_CASE_INPUT_PATH + "/" + testCase_Num + ".txt");
            output_tc_file = new File(LOCAL_PROBLEM_STORAGE_PATH + problemId + TEST_CASE_PATH + TEST_CASE_OUTPUT_PATH + "/" + testCase_Num + ".txt");
        }

        //테스트케이스를 모두 통과햇을경우
        response="정답 입니다!";

        return response;
    }


    //채점서버연결->코드전송
    public String Send_ScoringServer(String source_info) {
        try {
            URL url = new URL(SCORING_SERVER_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000);
            ; //서버에 연결되는 Timeout 시간설정
            con.setReadTimeout(7000); //InputStream 읽어 오는 Timeout 시간 설정
            con.setRequestMethod("POST");

            //json
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());

            wr.write(source_info);
            wr.flush();


            //응답
            StringBuilder sb = new StringBuilder();
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //Stream을 처리해줘야 하는 귀찮음이 있음.
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();
                System.out.println("" + sb.toString());
                return sb.toString();
            } else {
                System.out.println(con.getResponseMessage());
                return "오류";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }





}
