package com.qt.domain.problem;

import com.qt.domain.problem.dto.ProblemRequestInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Problem {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    //@NotNull
    //@Column(unique = true) //중복 허용 x
    //private String identifier;

    @NotNull
    private Double timeLimit;

    @NotNull
    private Double memoryLimit;

    @CreatedDate
    private LocalDateTime createTime;

    public Problem(@NotNull String name,  @NotNull Double timeLimit, @NotNull Double memoryLimit) {
        this.name = name;
        //this.identifier = identifier;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
    }

    public Long updateTo( ProblemRequestInfo problemRequestInfo) {
        this.name = problemRequestInfo.getName();
        //this.identifier = identifier;
        this.timeLimit = problemRequestInfo.getTimeLimit();
        this.memoryLimit = problemRequestInfo.getMemoryLimit();
        return id;
    }
}
