package com.qt.domain.question.dto;

import com.qt.domain.contest.Contest;
import com.qt.domain.question.Question;
//import com.qt.domain.student.Student; //student라는 패키지 만들것
import com.qt.domain.user.User; //혹은 user로 사용

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class QuestionInfo {

    @NotNull
    private Contest contest;

    @NotNull
    private Integer problemNumber;

    @NotNull
    @Lob
    private String content;

    @Lob
    private String response;

    @CreatedDate
    private LocalDateTime createTime;

    @Builder
    public QuestionInfo(@NotNull Contest contest, @NotNull Integer problemNumber, @NotNull String content, String response, LocalDateTime createTime) {
        this.contest = contest;
        this.problemNumber = problemNumber;
        this.content = content;
        this.response = response;
        this.createTime = createTime;
    }

    public Question toEntity() {
        return new Question(contest, problemNumber, content, response, createTime);
    }

    @Override
    public String toString() {
        return "QuestionInfo{" +
                "contest=" + contest +
                ", problemNumber=" + problemNumber +
                ", content='" + content + '\'' +
                ", response='" + response + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
