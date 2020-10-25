package com.qt.domain.submit.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ScoreBoard {
    private String StudentCode;
    private String problemName;
    private String result;
    private int score;

    @Builder
    public ScoreBoard(String studentCode, String problemName, String result, int score) {
        this.StudentCode = studentCode;
        this.problemName = problemName;
        this.result = result;
        this.score = score;
    }
}
