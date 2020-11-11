package com.qt.domain.assignment;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
public class assignment {

    @GeneratedValue
    @Id
    private long id;

    @NotNull
    private long deadLine;

    @NotNull
    private long subjectCode; //과제코드

    @NotNull
    private long submit_count; //제출횟수

    @NotNull
    private String content; //과제 내용

    @NotNull
    private boolean isReport; //레포트인지, false라면 코드과제이다.





}
