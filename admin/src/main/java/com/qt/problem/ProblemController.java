package com.qt.problem;

import com.qt.domain.problem.dto.FileInfo;
import com.qt.domain.problem.dto.ProblemRequestInfo;
import com.qt.domain.problem.dto.ProblemResponseInfo;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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

    //등록된 모든 문제 정보 조회
  //테스트 완료 : 업로드했던 문제들의 목록 정보들이 나옴
    @GetMapping
    public ResponseEntity<List<ProblemResponseInfo>> showAllProblems() {
        List<ProblemResponseInfo> problemResponseInfos = problemService.findAll();
        return ResponseEntity.ok(problemResponseInfos);
    }

    //테스트 완료: 문제를 업로드하는 부분, localhost:8080/problem-list.html에서 양식을제출하면 지정햇던 디렉터리에 파일이 업로드되고, 테이블에 정보저장
    @PostMapping
    public ResponseEntity createProblem(@ModelAttribute ProblemRequestInfo problemRequestInfo, @RequestParam MultipartFile file) throws IOException {
        Long problemId = problemService.save(problemRequestInfo, file);
        return ResponseEntity.created(URI.create("/problems/" + problemId)).build();
    }

    //등록된 특정 문제정보 조회
    //테스트 완료: localhost:8080/problems/{id}를치면 id에맞는 문제의 정보들이나옴
    @GetMapping("/{id}")
    public ResponseEntity<ProblemResponseInfo> showProblem(@PathVariable Long id) {
        ProblemResponseInfo problemResponseInfo = problemService.findById(id);
        return ResponseEntity.ok(problemResponseInfo);
    }

    //테스트 미완료: 문제를 다운로드하는 부분
    @GetMapping("/{id}/files")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException {
        FileInfo fileInfo = problemService.findProblemFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .header(HttpHeaders.CONTENT_LENGTH, fileInfo.getContentLength())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                .body(fileInfo.getResource());
    }

    //문제 업데이트
    //테스트 완료: localhost:8080/probles/{id}에 대해서 파라미터와 파일을 post로 전송을하면 테이블에서 그 id에 대한 정보들이 업데이트됨
    //postman으로 json형식으로 dto객체를 보낼수있지만, file까지 같이보낼경우 둘다 json형식으로 하든, 파라미터 파일형식으로 전달해야한다.
    @PostMapping("/{id}")
    public ResponseEntity updateProblem(@PathVariable Long id, @Valid ProblemRequestInfo problemRequestInfo, @RequestParam MultipartFile file, Errors error) throws IOException {
        if(error.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

        problemService.updateProblem(id, problemRequestInfo, file);
        return ResponseEntity.noContent().build();
    }

    //문제 삭제
    //테스트 완료: localhost:8080/problems/{id} 에대해서 Delete방식으로 파라미터없이전송하면 테이블내에서 그 id에 대한 정보들이 삭제됨
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProblem(@PathVariable Long id) throws IOException {
        problemService.deleteProblem(id);
        return ResponseEntity.noContent().build();
    }

    //테스트케이스 등록
    //테스트 완료: localhost:8080/problems/{id}/testcase 에 대해서 post방식으로 input 파일과 output파일을 보내면 그 id를 가진 디렉터리내에 테스트케이스 파일들이 저장됨(in, out)
    @PostMapping("/{id}/testcase")
    public ResponseEntity uploadTestcases(@PathVariable Long id, @RequestParam List<MultipartFile> in, @RequestParam List<MultipartFile> out) throws IOException {
        testcaseService.uploadTestcases(id, in, out);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity eventErrorHandler(RuntimeException exception) {
        return ResponseEntity.notFound().build();
    }
}
