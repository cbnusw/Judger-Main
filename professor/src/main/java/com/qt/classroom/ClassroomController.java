package com.qt.classroom;


import com.qt.domain.classroom.dto.ClassroomInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService)
    {
        this.classroomService=classroomService;
    }

    @PostMapping
    public ResponseEntity createClassroom(@ModelAttribute ClassroomInfo classroomInfo)
    {
        Long id=classroomService.save(classroomInfo);
        return ResponseEntity.created(URI.create("/classrooms/"+id)).build();
    }

    @GetMapping
    public ResponseEntity<List<ClassroomInfo>> showAllClassroomInfo()
    {
        List<ClassroomInfo> classroomInfos=classroomService.findAll();
        return ResponseEntity.ok(classroomInfos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomInfo> showClassroomInfo(@PathVariable Long id)
    {
        ClassroomInfo classroomInfo=classroomService.findById(id);
        return ResponseEntity.ok(classroomInfo);
    }

    @PostMapping("/{id}")
    public ResponseEntity updateClassroom(@PathVariable Long id, @ModelAttribute ClassroomInfo classroomInfo) {
        classroomService.updateClassroom(id, classroomInfo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity eventErrorHandler(NotFoundClassroomException exception) {
        return ResponseEntity.notFound().build();
    }


}
