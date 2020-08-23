package com.qt.domain.submit;

import com.qt.domain.testcase.Testcase;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//@Entity
@NoArgsConstructor
@Getter
@Setter //이것을해야지 컨트롤러에서 파라미터를받아서 생성자에게 넘겨줘서 객체를 생성시킴
public class SubmitInfo {

    //@Id
    //private long id;

    @NotNull
    private String source;

    @NotNull
    private String language;

    //@NotNull
    //private Testcase testcase;


    public SubmitInfo(@NotNull String source, @NotNull String language) {
        this.source = source;
        this.language = language;
    }
}
