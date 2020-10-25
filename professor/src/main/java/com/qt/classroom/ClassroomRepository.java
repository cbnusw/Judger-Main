package com.qt.classroom;

import com.qt.domain.classroom.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
