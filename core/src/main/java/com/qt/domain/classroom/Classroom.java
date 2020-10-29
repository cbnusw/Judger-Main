package com.qt.domain.classroom;

import com.qt.domain.classroom.dto.ClassroomInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
public class Classroom {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String subjectname;
    @NotNull
    private Long subjectnumber;
    @NotNull
    private String major;


    public Classroom(@NotNull String subjectname,@NotNull Long subjectnumber, @NotNull String major)
    {
        this.subjectname= subjectname;
        this.subjectnumber= subjectnumber;
        this.major=major;
    }

    public Long updateTo(ClassroomInfo classroominfo)
    {
        this.subjectname=classroominfo.getSubjectname();
        this.subjectnumber=classroominfo.getSubjectnumber();
        this.major=classroominfo.getMajor();

        return id;
    }

}
