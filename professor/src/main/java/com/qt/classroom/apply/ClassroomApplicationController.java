package com.qt.classroom.apply;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassroomApplicationController {

    private ClassroomApplicationService classroomApplicationService;

    public ClassroomApplicationController(ClassroomApplicationService classroomApplicationService)
    {
        this.classroomApplicationService=classroomApplicationService;
    }


    @PostMapping("/{classroomId}/apply/{userId}")
    public ResponseEntity applyClassroom(@PathVariable Long classroomId, @PathVariable Long userId) {
        Long classroomApplicationId = classroomApplicationService.apply(classroomId, userId);
        return ResponseEntity.created(URI.create("/classrooms/apply/" + classroomApplicationId)).build();
    }

    @GetMapping("/apply/{classroomApplicationId}")
    public ResponseEntity<ClassroomApplicationInfo> showClassroomApplication(@PathVariable Long classroomApplicationId) {
        ClassroomApplicationInfo classroomApplicationInfo = classroomApplicationService.findByClassroomApplicationId(classroomApplicationId);
        return ResponseEntity.ok(classroomApplicationInfo);
    }

    @GetMapping("/{classroomId}/apply")
    public ResponseEntity<List<ClassroomApplicationInfo>> showClassroomApplications(@PathVariable Long classroomId) {
        List<ClassroomApplicationInfo> classroomApplicationInfos = classroomApplicationService.findAllByClassroomId(classroomId);
        return ResponseEntity.ok(classroomApplicationInfos);
    }

    @PostMapping("/apply/approve/{classroomApplicationId}")
    public ResponseEntity changeApproveStatus(@PathVariable Long classroomApplicationId) {
        classroomApplicationService.changeApproveStatus(classroomApplicationId);
        return ResponseEntity.noContent().build();
    }

    //postmapping 하고 classroom member
}
