package com.qt.domain.problem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class ProblemResponseInfo {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Double timeLimit;

    @NotNull
    private Double memoryLimit;

    public ProblemResponseInfo(@NotNull Long id, @NotNull String name, @NotNull Double timeLimit, @NotNull Double memoryLimit) {
        this.id = id;
        this.name = name;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
    }
}
