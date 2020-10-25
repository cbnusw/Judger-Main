package com.qt.domain.homework.dto;

import com.qt.domain.homework.Homework;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
public class HomeworkInfo {


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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;

    @Builder
    public HomeworkInfo(@NotNull Long subjectNumber, @NotNull String homeworkName, @NotNull String identifier,String homeworkDescription, @NotNull LocalDate endDate,@NotNull LocalTime endTime)
    {
        this.subjectNumber=subjectNumber;
        this.homeworkName=homeworkName;
        this.identifier=identifier;
        this.homeworkDescription=homeworkDescription;
        this.endDate=endDate;
        this.endTime=endTime;
    }

    public Homework toEntity(){
        return new Homework(subjectNumber,homeworkName,identifier,homeworkDescription,endDate,endTime);
    }

    @Override
    public String toString()
    {
        return "HomeworkInfo{" +
                       "subjectnumber=" + subjectNumber +
                       ", homeworkname=" +homeworkName +
                       ", homeworkname=" +identifier +
                       ", homeworkdescription='" + homeworkDescription + '\'' +
                       ", endDate='" + endDate + '\'' +
                       ", endTime=" + endTime +
                       '}';

    }

}
