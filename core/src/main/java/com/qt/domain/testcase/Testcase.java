package com.qt.domain.testcase;

import com.qt.domain.problem.Problem;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class Testcase {

    @Id
    @GeneratedValue
    private Long id;

    private String input;

    private String output;

    @ManyToOne
    private Problem problem;

    public Testcase(String input, String output, Problem problem) {
        this.input = input;
        this.output = output;
        this.problem = problem;
    }
}
