package com.qt.problem;

import com.qt.domain.problem.dto.FileInfo;
import com.qt.domain.problem.dto.ProblemRequestInfo;
import com.qt.domain.problem.dto.ProblemResponseInfo;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/problems")
public class ProblemController {

    private final ProblemService problemService;
    private final TestcaseService testcaseService;

    public ProblemController(ProblemService problemService, TestcaseService testcaseService) {
        this.problemService = problemService;
        this.testcaseService = testcaseService;
    }

    @GetMapping
    public ResponseEntity<List<ProblemResponseInfo>> showAllProblems() {
        List<ProblemResponseInfo> problemResponseInfos = problemService.findAll();
        return ResponseEntity.ok(problemResponseInfos);
    }

    @PostMapping
    public ResponseEntity createProblem(@ModelAttribute ProblemRequestInfo problemRequestInfo, @RequestParam MultipartFile file) throws IOException {
        Long problemId = problemService.save(problemRequestInfo, file);
        return ResponseEntity.created(URI.create("/problems/" + problemId)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProblemResponseInfo> showProblem(@PathVariable Long id) {
        ProblemResponseInfo problemResponseInfo = problemService.findById(id);
        return ResponseEntity.ok(problemResponseInfo);
    }

    @GetMapping("/{id}/files")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException {
        FileInfo fileInfo = problemService.findProblemFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .header(HttpHeaders.CONTENT_LENGTH, fileInfo.getContentLength())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                .body(fileInfo.getResource());
    }

    @PostMapping("/{id}")
    public ResponseEntity updateProblem(@PathVariable Long id, @ModelAttribute ProblemRequestInfo problemRequestInfo, @RequestParam MultipartFile file) throws IOException {
        problemService.updateProblem(id, problemRequestInfo, file);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProblem(@PathVariable Long id) throws IOException {
        problemService.deleteProblem(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/testcase")
    public ResponseEntity uploadTestcases(@PathVariable Long id, @RequestParam List<MultipartFile> in, @RequestParam List<MultipartFile> out) throws IOException {
        testcaseService.uploadTestcases(id, in, out);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity eventErrorHandler(NotFoundProblemException exception) {
        return ResponseEntity.notFound().build();
    }
}
