package com.qt.repository;

import com.qt.domain.classroom.ClassroomHomeworkRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomHomeworkRegistrationRepository extends JpaRepository<ClassroomHomeworkRegistration, Long> {

    List<ClassroomHomeworkRegistration> findAllByClassroomId(Long classroomId);

}