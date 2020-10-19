package com.qt.classroom.regist;

import com.qt.domain.homework.dto.HomeworkInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassroomHomeworkRegistrationController {

    private final ClassroomHomeworkRegistrationService classroomHomeworkRegistrationService;

    public ClassroomHomeworkRegistrationController(ClassroomHomeworkRegistrationService classroomHomeworkRegistrationService)
    {
        this.classroomHomeworkRegistrationService=classroomHomeworkRegistrationService;
    }

    @PostMapping("{classroomId}/homeworks")
    public ResponseEntity registerHomeworks(@PathVariable Long classroomId, @RequestParam List<Long> homeworkIds)
    {
        classroomHomeworkRegistrationService.registerHomework(classroomId,homeworkIds);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{classroomId}/homeworks")
    public ResponseEntity<List<HomeworkInfo>> showRegisteredHomeworks(@PathVariable Long classroomId)
    {
        List<HomeworkInfo> homeworkInfos=classroomHomeworkRegistrationService.showRegistrationHomeworks(classroomId);
        return ResponseEntity.ok(homeworkInfos);
    }
}
