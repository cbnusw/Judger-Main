package com.qt.domain.testcase.dto;


import com.qt.domain.problem.Problem;
import com.qt.domain.testcase.Testcase;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class TestcaseInfo {

    @NotNull
    private String input;

    @NotNull
    private String output;

    @ManyToOne
    private Problem problem;

    @Builder
    public TestcaseInfo(@NotNull String input, @NotNull String output, Problem problem) {
        this.input = input;
        this.output = output;
        this.problem = problem;
    }

    public Testcase toEntity(){ return new Testcase(input,output,problem);}

}
