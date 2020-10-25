package com.qt.domain.submit.dto;

import com.qt.domain.problem.Problem;
import com.qt.domain.submit.Submit;
import com.qt.domain.testcase.Testcase;
import com.qt.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@Getter
@Setter //이것을해야지 컨트롤러에서 파라미터를받아서 생성자에게 넘겨줘서 객체를 생성시킴
public class SubmitRequest {


    @NotNull
    private String source;

    @NotNull
    private String language;




}
