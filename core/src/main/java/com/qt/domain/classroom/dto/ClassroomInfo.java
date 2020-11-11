package com.qt.domain.classroom.dto;

import com.qt.domain.classroom.Classroom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class ClassroomInfo {

    @NotNull
    private String subjectname;

    @NotNull
    private Long subjectnumber;

    @NotNull
    private String major;


    @Builder
    public ClassroomInfo(@NotNull String subjectname, @NotNull Long subjectnumber, @NotNull String major) {
        this.subjectname=subjectname;
        this.subjectnumber=subjectnumber;
        this.major=major;
    }

    public Classroom toEntity() {
        return new Classroom(subjectname, subjectnumber, major);
    }

    @Override
    public String toString() {
        return "subjectname='" + subjectname +
                ", subjectnumber='" + subjectnumber + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
