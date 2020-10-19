package com.qt.classroom.apply;

import com.qt.domain.classroom.ClassroomApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomApplicationRepository extends JpaRepository<ClassroomApplication, Long> {
    List<ClassroomApplication> findAllByClassroomId(Long classroomId);
    List<ClassroomApplication> findAllByUserId(Long userId);
}
