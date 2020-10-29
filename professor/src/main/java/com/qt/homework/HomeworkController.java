package com.qt.homework;

import com.qt.domain.homework.dto.FileInfo;
import com.qt.domain.homework.dto.HomeworkInfo;
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
@RequestMapping("/homeworks")
public class HomeworkController {

    public final HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping
    public ResponseEntity<List<HomeworkInfo>> showAllHomeworks() {
        List<HomeworkInfo> homeworkInfos = homeworkService.findAll();
        return ResponseEntity.ok(homeworkInfos);
    }


    @PostMapping
    public ResponseEntity createHomework(@ModelAttribute HomeworkInfo homeworkInfo, MultipartFile file) throws IOException {
        Long homeworkId = homeworkService.save(homeworkInfo, file);
        return ResponseEntity.created(URI.create("/homeworks/" + homeworkId)).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<HomeworkInfo> showHomework(@PathVariable Long id) {
        HomeworkInfo homeworkInfo = homeworkService.findById(id);
        return ResponseEntity.ok(homeworkInfo);

    }

    @GetMapping("/{id}/files")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException {
        FileInfo fileInfo = homeworkService.findHomeworkFile(id);
        return ResponseEntity.ok()
                       .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                       .header(HttpHeaders.CONTENT_LENGTH, fileInfo.getContentLength())
                       .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                       .body(fileInfo.getResource());
    }

    @PostMapping("/{id}")
    public ResponseEntity updateHomework(@PathVariable Long id, @ModelAttribute HomeworkInfo homeworkInfo, @RequestParam MultipartFile file) throws IOException {
        homeworkService.updateHomework(id, homeworkInfo, file);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHomework(@PathVariable Long id) throws IOException {
        homeworkService.deleteHomework(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity eventErrorHandler(NotFoundHomeworkException exception) {
        return ResponseEntity.notFound().build();
    }

}
