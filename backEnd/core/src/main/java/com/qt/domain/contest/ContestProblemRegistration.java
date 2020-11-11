package com.qt.domain.contest;

import com.qt.domain.problem.Problem;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
public class ContestProblemRegistration {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private Contest contest;

    @NotNull
    @ManyToOne
    private Problem problem;

    public ContestProblemRegistration(@NotNull Contest contest, @NotNull Problem problem) {
        this.contest = contest;
        this.problem = problem;
    }
}
