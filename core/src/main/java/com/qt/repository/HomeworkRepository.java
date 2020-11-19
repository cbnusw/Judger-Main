package com.qt.repository;

import com.qt.domain.homework.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
}
