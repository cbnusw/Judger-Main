package com.qt.domain.classroom;

import com.qt.domain.homework.Homework;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
public class ClassroomHomeworkRegistration {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private Classroom classroom;

    @NotNull
    @ManyToOne
    private Homework homework;

    public ClassroomHomeworkRegistration(@NotNull Classroom classroom,@NotNull Homework homework)
    {
        this.classroom=classroom;
        this.homework=homework;
    }

}
