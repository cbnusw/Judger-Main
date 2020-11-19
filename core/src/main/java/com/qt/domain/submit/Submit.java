package com.qt.domain.submit;

import com.qt.domain.problem.Problem;
import com.qt.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
public class Submit {

    @Id
    @GeneratedValue
    private long id;

    //@NotNull
    //private String source;

    //제출횟수
    //private int submitCount=0;

    @NotNull
    private String language;


    //문제
    @ManyToOne
    @NotNull
    private Problem problem;


    //유저
    @ManyToOne
    @NotNull
    private User user;

    @NotNull
    private String result;

    public Submit(@NotNull String language,  @NotNull Problem problem, @NotNull User user, @NotNull String result) {

        this.language = language;
        this.problem = problem;
        this.user = user;
        this.result=result;
    }


}
