package com.qt.problem;

import com.qt.domain.problem.Problem;
import com.qt.domain.testcase.dto.TestcaseInfo;
import com.qt.problem.testcase.TestcaseRepository;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class TestcaseService {

    private static final String LOCAL_PROBLEM_STORAGE_PATH = "C:\\Users\\jtm06\\javaProject\\git_home\\Judger-Main-Server-master\\Judger-Main-Server-master\\admin\\src\\main\\resources\\problems";
    private static final String TEST_CASE_PATH = "/tc";
    private static final String TEST_CASE_INPUT_PATH = "/in";
    private static final String TEST_CASE_OUTPUT_PATH = "/out";

    private final ProblemRepository problemRepository;
    private final TestcaseRepository testcaseRepository;

    public TestcaseService(ProblemRepository problemRepository, TestcaseRepository testcaseRepository) {
        this.problemRepository = problemRepository;
        this.testcaseRepository=testcaseRepository;
    }
    @Transactional(readOnly = true)
    public void uploadTestcases(Long id, List<MultipartFile> in, List<MultipartFile> out) throws IOException {


     //   String identifier = problemRepository.findById(id).orElseThrow(NotFoundProblemException::new).getIdentifier();
        String testcaseDirectory2 = LOCAL_PROBLEM_STORAGE_PATH + id;
        new File(testcaseDirectory2).mkdir();

        String testcaseDirectory = LOCAL_PROBLEM_STORAGE_PATH + id + TEST_CASE_PATH;
        new File(testcaseDirectory).mkdir();

        String inputDirectory = testcaseDirectory + TEST_CASE_INPUT_PATH;
        String outputDirectory = testcaseDirectory + TEST_CASE_OUTPUT_PATH;
        new File(inputDirectory).mkdir();
        new File(outputDirectory).mkdir();

        for (MultipartFile input : in) {
            input.transferTo(new File(inputDirectory + "/" + input.getOriginalFilename()));
        }

        for (MultipartFile output : out) {
            output.transferTo(new File(outputDirectory + "/" + output.getOriginalFilename()));
        }


    }


}
