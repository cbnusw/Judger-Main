package com.qt.domain.question;

import com.qt.domain.user.User;
import com.qt.domain.contest.Contest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Contest contest;


    @CreatedBy
    @ManyToOne
    private User user;

    @NotNull
    private Integer problemNumber;

    @Lob
    private String content;

    @Lob
    private String response;

    @CreatedDate
    private LocalDateTime createTime;

    public Question(@NotNull Contest contest, @NotNull Integer problemNumber, @NotNull String content, String response, LocalDateTime createTime) {
        this.contest = contest;
        this.problemNumber = problemNumber;
        this.content = content;
        this.response = response;
        this.createTime = createTime;
    }
}
