package com.qt.domain.question.dto;

import com.qt.domain.contest.Contest;
import com.qt.domain.question.Question;
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
    private String reply;


    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createTime;

    @Builder
    public QuestionInfo(@NotNull Contest contest, @NotNull Integer problemNumber, @NotNull String content, LocalDateTime createTime, String reply) {
        this.contest = contest;
        this.problemNumber = problemNumber;
        this.content = content;
        this.createTime = createTime;
        this.reply=reply;
    }

    public Question toEntity() {
        return new Question(contest, problemNumber, content, createTime,reply);
    }

    @Override
    public String toString() {
        return "QuestionInfo{" +
                "contest=" + contest +
                ", problemNumber=" + problemNumber +
                ", reply=" +reply +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
