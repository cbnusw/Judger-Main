package com.qt.domain.submit.dto;

import com.qt.domain.contest.Contest;
import com.qt.domain.problem.Problem;
import com.qt.domain.submit.ContestSubmit;
import com.qt.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class ContestSubmitResponse {


        @NotNull
        private String language;

        @Lob
        private String source;

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

        @NotNull
        private int submitCount;

        public ContestSubmit toEntity(){
            return new ContestSubmit(language,contest,problem,user,result,submitCount,source);
        }
}
