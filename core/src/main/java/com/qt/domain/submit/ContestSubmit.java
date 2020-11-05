package com.qt.domain.submit;

import com.qt.domain.contest.Contest;
import com.qt.domain.contest.ContestProblemRegistration;
import com.qt.domain.problem.Problem;
import com.qt.domain.submit.dto.SubmitRequest;
import com.qt.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
public class ContestSubmit {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String source;

    //제출횟수
    @NotNull
    private int submitCount;

    @NotNull
    private String language;

    //컨테스트정보
    @ManyToOne
   @NotNull
    private Contest contest;

    //문제정보
    @ManyToOne
    @NotNull
    private Problem problem;


    //유저
    @ManyToOne
    @NotNull
    private User user;

    @NotNull
    private String result;


    public ContestSubmit(@NotNull String language, @NotNull Contest contest, @NotNull Problem problem, @NotNull User user, @NotNull String result,@NotNull int submitCount, @NotNull String source) {
        this.language = language;
        this.contest = contest;
        this.problem = problem;
        this.user = user;
        this.result = result;
        this.submitCount=submitCount;
        this.source=source;
    }

    public Long UpdateTo(SubmitRequest submitRequest){
        this.language=submitRequest.getLanguage();
        countUp();
        return id;
    }

    private void countUp(){
        this.submitCount++;
    }

}
