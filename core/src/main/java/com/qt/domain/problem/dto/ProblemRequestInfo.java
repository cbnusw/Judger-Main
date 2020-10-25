package com.qt.domain.problem.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class ProblemRequestInfo {

    @NotNull
    private String name;

    @NotNull
    private Double timeLimit;

    @NotNull
    private Double memoryLimit;

    public ProblemRequestInfo(@NotNull String name, @NotNull Double timeLimit, @NotNull Double memoryLimit) {
        this.name = name;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
    }
}
