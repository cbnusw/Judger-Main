package com.qt.problem;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class TestcaseService {

    private static final String LOCAL_PROBLEM_STORAGE_PATH = "/Users/hyogeon/IdeaProjects/judger-main-server/admin/src/main/resources/static/problems/";
    private static final String TEST_CASE_PATH = "/tc";
    private static final String TEST_CASE_INPUT_PATH = "/in";
    private static final String TEST_CASE_OUTPUT_PATH = "/out";

    private final ProblemRepository problemRepository;

    public TestcaseService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public void uploadTestcases(Long id, List<MultipartFile> in, List<MultipartFile> out) throws IOException {
        String identifier = problemRepository.findById(id).orElseThrow(NotFoundProblemException::new).getIdentifier();
        String testcaseDirectory = LOCAL_PROBLEM_STORAGE_PATH + identifier + TEST_CASE_PATH;
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
