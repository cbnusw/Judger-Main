package com.qt.repository;

import com.qt.domain.classroom.ClassroomApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomApplicationRepository extends JpaRepository<ClassroomApplication, Long> {
    public List<ClassroomApplication> findAllByClassroomId(Long classroomId);
    public List<ClassroomApplication> findAllByUserId(Long userId);

    //find by classroomId and approved
    //public List<ClassroomApplication> findAllByClassroomIdAnAndIsApproved(Long classroomId,Boolean IsApproved);
}
