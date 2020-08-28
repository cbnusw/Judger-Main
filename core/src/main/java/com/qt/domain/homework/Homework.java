package com.qt.domain.homework;

import com.qt.domain.homework.dto.HomeworkInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

//
//
//
@Entity
@Getter
@NoArgsConstructor
public class Homework {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Long subjectNumber;

    @NotNull
    private String homeworkName;

    @NotNull
    @Column(unique =true)
    private String identifier;

    @Lob
    private String homeworkDescription;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private LocalTime endTime;


    public Homework(@NotNull Long subjectNumber, @NotNull String homeworkName,@NotNull String identifier,String homeworkDescription, @NotNull LocalDate endDate,@NotNull LocalTime endTime)
    {
        this.subjectNumber=subjectNumber;
        this.homeworkName=homeworkName;
        this.identifier=identifier;
        this.homeworkDescription=homeworkDescription;
        this.endDate=endDate;
        this.endTime=endTime;
    }

    public Long updateTo(String identifier,HomeworkInfo homeworkInfo)
    {
        this.subjectNumber=homeworkInfo.getSubjectNumber();
        this.homeworkName=homeworkInfo.getHomeworkName();
        this.identifier=identifier;
        this.homeworkDescription=getHomeworkDescription();
        this.endDate=getEndDate();
        this.endTime=getEndTime();

        return id;
    }
}
