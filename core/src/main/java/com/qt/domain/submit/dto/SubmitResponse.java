package com.qt.domain.submit.dto;

import com.qt.domain.problem.Problem;
import com.qt.domain.submit.Submit;
import com.qt.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class SubmitResponse {

    @NotNull
    private String language;


    @NotNull
    private Problem problem;

    @NotNull
    private User user;

    @NotNull
    private String result;


    public Submit toEntity(){
        return new Submit(language,problem,user,result);
    }
}
